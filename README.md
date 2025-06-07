# 機構資料管理系統

## 專案簡介

這是一個基於 Spring Boot 的機構資料管理系統，用於管理機構資訊並支援 CSV 檔案批量匯入功能。專案是 iSpan EEIT198 期中考試項目。

## 功能特色

- 🔐 **使用者登入系統**：帳號密碼登入機制
- 📊 **機構資料管理**：支援機構資料的新增、修改、刪除、查詢（CRUD）操作
- 📁 **CSV 檔案匯入**：支援批量上傳 CSV 檔案並自動轉檔匯入資料庫
- 🌐 **Web 介面**：提供友善的網頁操作界面
- 🗃️ **資料庫整合**：使用 JPA/Hibernate 與 SQL Server 資料庫整合

## 技術棧

### 後端技術
- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **Spring Web MVC**
- **Thymeleaf** (模板引擎)

### 資料庫
- **Microsoft SQL Server**
- **Hibernate** (ORM)

### 前端技術
- **HTML5**
- **CSS3**
- **JavaScript**
- **Thymeleaf**

### 其他依賴
- **OpenCSV 5.7.1** (CSV 檔案處理)

## 系統需求

- **Java**: JDK 21 或以上版本
- **Maven**: 3.6 或以上版本
- **資料庫**: Microsoft SQL Server

## 安裝與設定

### 1. clone專案
```bash
git clone https://github.com/d361120041/EEITMidTerm.git
cd midterm-project
```

### 2. 資料庫設定
確保 SQL Server 已安裝並運行，並創建名為 `javamidterm` 的資料庫。

建立所需的資料表：

#### accounts 資料表
```sql
CREATE TABLE accounts (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    account NVARCHAR(50) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    createdby NVARCHAR(50),
    createdat DATETIME2,
    modifiedby NVARCHAR(50),
    modifiedat DATETIME2
);
```

#### institutions 資料表
```sql
CREATE TABLE institutions (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    institutionname NVARCHAR(255),
    institutioncode NVARCHAR(50),
    address NVARCHAR(500),
    serviceitems NVARCHAR(1000),
    phone NVARCHAR(50),
    email NVARCHAR(100),
    managername NVARCHAR(100),
    contractstartdate DATE,
    contractenddate DATE,
    lastmodifieddate DATE,
    createdby NVARCHAR(50),
    createdat DATETIME2,
    modifiedby NVARCHAR(50),
    modifiedat DATETIME2
);
```

### 3. 應用程式設定
修改 `src/main/resources/application.yml` 中的資料庫連線資訊：

```yaml
spring:
  datasource:
    driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
    url: jdbc:sqlserver://127.0.0.1:1433;DatabaseName=javamidterm;trustServerCertificate=true;
    username: your_username
    password: your_password
```
應用程式將在 `http://localhost:8080` 啟動。

## 使用方式

### 1. 登入系統
- 訪問 `http://localhost:8080`
- 點擊「登入」連結
- 輸入帳號和密碼進行登入

### 2. 機構資料管理
登入後可進行以下操作：
- **新增機構**：填寫機構資訊後點擊「新增」
- **修改機構**：輸入機構 ID 及要修改的資訊後點擊「修改」
- **刪除機構**：輸入機構 ID 後點擊「刪除」
- **查詢機構**：可依條件查詢或查詢全部資料

### 3. CSV 檔案匯入
- 在機構管理頁面選擇「檔案上傳」區域
- 選擇符合格式的 CSV 檔案
- 點擊「上傳並轉檔」進行批量匯入

## CSV 檔案格式

CSV 檔案應包含以下欄位（按順序）：
1. 機構名稱
2. 機構代碼
3. （其他欄位）...
4. （其他欄位）...
5. （其他欄位）...
6. 地址全址
7. （其他欄位）...
8. （其他欄位）...
9. （其他欄位）...
10. 特約服務項目
11. （其他欄位）...
12. （其他欄位）...
13. 機構電話
14. 電子郵件
15. 機構負責人姓名
16. 特約起日 (格式: yyyyMMdd)
17. 特約迄日 (格式: yyyyMMdd)
18. 最後異動時間 (格式: yyyyMMdd HH:mm:ss)

## 專案結構

```
midterm-project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── tw/danielchiang/
│   │   │       ├── controller/          # 控制器層
│   │   │       ├── domain/              # 實體類別
│   │   │       ├── repository/          # 資料存取層
│   │   │       ├── service/             # 業務邏輯層
│   │   │       └── util/                # 工具類別
│   │   └── resources/
│   │       ├── templates/               # Thymeleaf 模板
│   │       └── application.yml          # 應用程式設定
├── pom.xml                              # Maven 設定檔
└── README.md                            # 專案說明文件
```

## API 端點

| 端點 | 方法 | 描述 |
|------|------|------|
| `/` | GET | 首頁 |
| `/secure/login` | GET/POST | 登入頁面/登入處理 |
| `/pages/institution` | GET/POST | 機構管理頁面/機構資料操作 |
| `/pages/display` | GET | 資料顯示頁面 |
| `/controller/pages/fileupload` | POST | 檔案上傳處理 |

## 開發環境

建議使用以下 IDE 和工具：
- **IntelliJ IDEA** 或 **Eclipse**
- **Maven** 依賴管理
- **Git** 版本控制
- **Postman** API 測試（可選）

### 常見問題

1. **資料庫連線失敗**
   - 檢查 SQL Server 是否運行
   - 確認資料庫名稱、使用者名稱和密碼正確
   - 檢查防火牆設定

2. **檔案上傳失敗**
   - 確認檔案大小不超過 10MB
   - 檢查 CSV 檔案格式是否正確
   - 確認伺服器有足夠的暫存空間

3. **應用程式啟動失敗**
   - 檢查 Java 版本是否為 21 或以上
   - 確認 Maven 依賴是否正確下載
   - 檢查 application.yml 設定是否正確

## 授權

本專案為 iSpan EEIT198 期中考試專案，僅供學習和評估使用。

---

*最後更新：2025年6月*
