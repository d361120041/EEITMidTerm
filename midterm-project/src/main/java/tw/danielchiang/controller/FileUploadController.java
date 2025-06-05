package tw.danielchiang.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import tw.danielchiang.domain.Account;
import tw.danielchiang.util.FileProcessor;

@Controller
public class FileUploadController {

    @Autowired
    private FileProcessor fileProcessor;

    @PostMapping("/controller/pages/fileupload")
    public String uploadFile(@RequestPart("file") MultipartFile file, Model model, HttpSession session) {
    	
    	// 取得使用者資料
    	Account user = (Account)session.getAttribute("user");
    	String userAccount = user.getAccount();
    	
    	if (file.isEmpty()) {
            model.addAttribute("fileupload", "未選擇檔案");
            return "/pages/institution";
        }
        
        // 使用 try-with-resources 確保流被正確關閉
        File tempFile = null;
        try {
            // 暫存檔案
            tempFile = File.createTempFile("upload_", ".csv");

            try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                fos.write(file.getBytes());
            }

            // 呼叫轉檔程式
            fileProcessor.processFile(tempFile.getAbsolutePath(), userAccount);

            model.addAttribute("fileupload", "檔案上傳成功");
        } catch (IOException e) {
            model.addAttribute("fileupload", "檔案上傳失敗，原因為IO錯誤");
            e.printStackTrace();
        } catch (Exception e) {
            model.addAttribute("fileupload", "檔案上傳失敗");
            e.printStackTrace();
        } finally {
            // 刪除暫存檔案，無論是否發生異常
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }

        return "/pages/institution";
    }
}
