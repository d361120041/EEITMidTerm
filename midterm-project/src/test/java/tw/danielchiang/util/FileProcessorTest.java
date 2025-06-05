package tw.danielchiang.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.danielchiang.service.InstitutionService;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FileProcessorTest {

    @Autowired
    private FileProcessor fileProcessor;  // 自動注入 FileProcessor 類別

    @Autowired
    private InstitutionService institutionService; // 自動注入 InstitutionService 類別

    @Test
    public void testProcessFile() throws Exception {
        // 模擬測試用的 CSV 檔案路徑
        String testFilePath = "C:/JavaFramework/midterm_workspace/data_source/abc.csv"; // 請確保此檔案在資料夾中

        // 呼叫 FileProcessor 類別的 processFile 方法
        fileProcessor.processFile(testFilePath, "test");

        // 檢查檔案是否存在，這是最基本的檢查
        boolean fileExists = Files.exists(Paths.get(testFilePath));
        System.out.println("檔案應該存在");
        assertTrue(fileExists, "檔案應該存在");

        // 這裡可以進一步檢查 `InstitutionService` 的 insert 方法是否被調用過
        // 假設 InstitutionService 有某些改變或輸出，這可以根據需求進行檢查

        // 假設 `InstitutionService` 會改變某些狀態或資料庫
        System.out.println("InstitutionService 應該被正確注入");
        assertNotNull(institutionService, "InstitutionService 應該被正確注入");
    }
}
