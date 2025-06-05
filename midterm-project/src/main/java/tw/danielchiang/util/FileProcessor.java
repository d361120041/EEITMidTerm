package tw.danielchiang.util;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

import tw.danielchiang.domain.Institution;
import tw.danielchiang.service.InstitutionService;

@Component
public class FileProcessor {

    @Autowired
    private InstitutionService institutionService;

    public void processFile(String filePath, String userAccount) throws Exception {
    	
        // 自訂日期格式
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

        // 預設值
        String defaultDate = "20250101"; // 預設日期
        String defaultDateTime = "20250101 00:00:00"; // 預設日期時間

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] data;
            boolean isFirstLine = true;
            

            while ((data = csvReader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // 略過第一行標題
                    continue;
                }

                Institution institution = new Institution();
                
                // 依硬編碼索引設置欄位資料
                institution.setInstitutionname(data[0]); // "機構名稱"
                institution.setInstitutioncode(data[1]); // "機構代碼"
                institution.setAddress(data[5]); // "地址全址"
                institution.setServiceitems(data[9]); // "特約服務項目"
                institution.setPhone(data[12]); // "機構電話"
                institution.setEmail(data[13]); // "電子郵件"
                institution.setManagername(data[14]); // "機構負責人姓名"

                // 處理 ContractStartDate (特約起日)
                String contractStartDateStr = data[15].replaceAll("\"", "").trim();
                if (contractStartDateStr.isEmpty()) {
                    institution.setContractstartdate(LocalDate.parse(defaultDate, dateFormatter));
                } else {
                    institution.setContractstartdate(LocalDate.parse(contractStartDateStr, dateFormatter));
                }

                // 處理 ContractEndDate (特約迄日)
                String contractEndDateStr = data[16].replaceAll("\"", "").trim();
                if (contractEndDateStr.isEmpty()) {
                    institution.setContractenddate(LocalDate.parse(defaultDate, dateFormatter));
                } else {
                    institution.setContractenddate(LocalDate.parse(contractEndDateStr, dateFormatter));
                }

                // 處理 LastModifiedDate (最後異動時間)
                String lastModifiedDateStr = data[17].replaceAll("\"", "").trim();
                if (lastModifiedDateStr.isEmpty()) {
                    institution.setLastmodifieddate(LocalDateTime.parse(defaultDateTime, dateTimeFormatter).toLocalDate());
                } else {
                    institution.setLastmodifieddate(LocalDateTime.parse(lastModifiedDateStr, dateTimeFormatter).toLocalDate());
                }

                // 儲存資料到資料庫
                institution.setCreatedby(userAccount);
                institutionService.insert(institution);
            }
        }
    }
}
