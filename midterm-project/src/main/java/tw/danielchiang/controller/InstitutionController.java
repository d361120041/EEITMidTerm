package tw.danielchiang.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import tw.danielchiang.domain.Account;
import tw.danielchiang.domain.Institution;
import tw.danielchiang.service.InstitutionService;

@Controller
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    // 錯誤訊息常數
    private static final String ERROR_ID_FORMAT = "機構id必須為整數";
    private static final String ERROR_NAME_EMPTY = "機構名稱不得為空";
    private static final String ERROR_CODE_FORMAT = "機構代碼必須是有效的字母和數字組合";
    private static final String ERROR_ADDRESS_FORMAT = "地址格式錯誤，請確認是否符合正確的格式";
    private static final String ERROR_SERVICE_EMPTY = "特約服務項目不得為空";
    private static final String ERROR_PHONE_FORMAT = "機構電話格式錯誤，應為有效的電話號碼";
    private static final String ERROR_EMAIL_FORMAT = "電子郵件格式錯誤，請輸入有效的電子郵件地址";
    private static final String ERROR_MANAGER_EMPTY = "機構負責人姓名不得為空";
    private static final String ERROR_DATE_FORMAT = "必須是有效的日期格式 (yyyy-MM-dd)";
    private static final String ERROR_DATETIME_FORMAT = "資料建立時間必須是有效的日期時間格式 (yyyy-MM-dd HH:mm:ss)";
    private static final String ERROR_ACTION_ERROR = "錯誤動作";

    @PostMapping("/controller/pages/institution")
    public String method(HttpSession session, Model model, String button, String institutionName, Institution institution, BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        model.addAttribute("errors", errors);

        // 處理錯誤訊息
        handleValidationErrors(bindingResult, errors);

        // 根據 button 動作檢查資料
        handleButtonValidation(button, institution, errors);

        // 若有錯誤，返回頁面
        if (!errors.isEmpty()) {
            return "/pages/institution";
        }

        // 根據 button 動作呼叫相對應的企業邏輯
        switch (button) {
            case "Select":
                return handleSelect(institution, model);
            case "Insert":
                return handleInsert(institution, model, errors, session);
            case "Update":
                return handleUpdate(institution, model, errors, session);
            case "Delete":
                return handleDelete(institution, model, errors);
            default:
                errors.put("action", ERROR_ACTION_ERROR);
                return "/pages/institution";
        }
    }

    private void handleValidationErrors(BindingResult bindingResult, Map<String, String> errors) {
        if (bindingResult != null) {
            if (bindingResult.hasFieldErrors("id")) errors.put("id", ERROR_ID_FORMAT);
            if (bindingResult.hasFieldErrors("institutionname")) errors.put("institutionname", ERROR_NAME_EMPTY);
            if (bindingResult.hasFieldErrors("institutioncode")) errors.put("institutioncode", ERROR_CODE_FORMAT);
            if (bindingResult.hasFieldErrors("address")) errors.put("address", ERROR_ADDRESS_FORMAT);
            if (bindingResult.hasFieldErrors("serviceitems")) errors.put("serviceitems", ERROR_SERVICE_EMPTY);
            if (bindingResult.hasFieldErrors("phone")) errors.put("phone", ERROR_PHONE_FORMAT);
            if (bindingResult.hasFieldErrors("email")) errors.put("email", ERROR_EMAIL_FORMAT);
            if (bindingResult.hasFieldErrors("managername")) errors.put("managername", ERROR_MANAGER_EMPTY);
            if (bindingResult.hasFieldErrors("contractstartdate")) errors.put("contractstartdate", ERROR_DATE_FORMAT);
            if (bindingResult.hasFieldErrors("contractenddate")) errors.put("contractenddate", ERROR_DATE_FORMAT);
            if (bindingResult.hasFieldErrors("lastmodifieddate")) errors.put("lastmodifieddate", ERROR_DATE_FORMAT);
            if (bindingResult.hasFieldErrors("createdby")) errors.put("createdby", "資料建立者帳號不得為空");
            if (bindingResult.hasFieldErrors("createdat")) errors.put("createdat", ERROR_DATETIME_FORMAT);
            if (bindingResult.hasFieldErrors("modifiedby")) errors.put("modifiedby", "資料修改者帳號不得為空");
            if (bindingResult.hasFieldErrors("modifiedat")) errors.put("modifiedat", ERROR_DATETIME_FORMAT);
        }
    }

    private void handleButtonValidation(String button, Institution institution, Map<String, String> errors) {
        if ("Insert".equals(button) && institution.getId() != null) {
            errors.put("id", "請勿輸入Id以便於執行" + button);
        }

        if (("Update".equals(button) || "Delete".equals(button)) && (institution == null || institution.getId() == null)) {
            errors.put("id", "請輸入Id以便於執行" + button);
        }
    }

    private String handleSelect(Institution institution, Model model) {
        List<Institution> institutions = institutionService.select(institution);
        model.addAttribute("select", institutions);
        return "/pages/display";
    }

    private String handleInsert(Institution institution, Model model, Map<String, String> errors, HttpSession session) {
    	
    	// 若新增沒有輸入建立使用者，則填入登入使用者
    	if (institution.getCreatedby() == null) {
    		Object user = session.getAttribute("user");
    		Account temp = null;
    		if (user!=null) {
    			temp = (Account)user;
    		}
    		institution.setCreatedby(temp.getAccount());
    	}
    	
        Institution insert = institutionService.insert(institution);
        if (insert != null) {
            model.addAttribute("insert", insert);
            session.setAttribute("insertUser", insert);
            errors.put("action", "新增成功");
        } else {
            errors.put("action", "新增失敗");
        }
        return "/pages/institution";
    }

    private String handleUpdate(Institution institution, Model model, Map<String, String> errors, HttpSession session) {
    	
    	// 自動填入修改使用者
    	Object user = session.getAttribute("user");
		Account temp = null;
		if (user!=null) {
			temp = (Account)user;
		}
		institution.setModifiedby(temp.getAccount());
		institution.setModifiedat(LocalDateTime.now());
    	
    	Institution update = institutionService.update(institution);
        if (update != null) {
            model.addAttribute("update", update);
            errors.put("action", "修改成功");
        } else {
            errors.put("action", "修改失敗");
        }
        return "/pages/institution";
    }

    private String handleDelete(Institution institution, Model model, Map<String, String> errors) {
        boolean delete = institutionService.delete(institution);
        if (delete) {
            model.addAttribute("delete", 1);
            errors.put("action", "刪除成功");
        } else {
            errors.put("action", "刪除失敗");
        }
        return "/pages/institution";
    }
}
