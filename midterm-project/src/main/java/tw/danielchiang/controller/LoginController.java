package tw.danielchiang.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import tw.danielchiang.domain.Account;
import tw.danielchiang.service.AccountService;

@Controller
public class LoginController {
    
    @Autowired
    private AccountService accountService;

    // 錯誤訊息常數
    private static final String ERROR_ACCOUNT_EMPTY = "請輸入帳號";
    private static final String ERROR_PASSWORD_EMPTY = "請輸入密碼";
    private static final String ERROR_LOGIN_FAILED = "登入失敗，請檢查您的帳號和密碼。";

    @PostMapping("/controller/secure/login")
    public String login(Model model, String account, String password, HttpSession session) {
        // 初始化錯誤訊息 Map
        Map<String, String> errors = new HashMap<>();
        model.addAttribute("errors", errors);

        // 驗證帳號和密碼
        if (account == null || account.isEmpty()) {
            errors.put("account", ERROR_ACCOUNT_EMPTY);
        }
        if (password == null || password.isEmpty()) {
            errors.put("password", ERROR_PASSWORD_EMPTY);
        }

        // 如果有錯誤，則返回登入頁面
        if (!errors.isEmpty()) {
            return "/secure/login";
        }

        // 呼叫企業邏輯處理登入
        Account login = accountService.login(account, password);

        // 處理登入失敗情況
        if (login == null) {
            errors.put("password", ERROR_LOGIN_FAILED);
            return "/secure/login";
        }

        // 登入成功，設置 session 並重定向到首頁
        session.setAttribute("user", login);
        return "redirect:/index";
    }
}
