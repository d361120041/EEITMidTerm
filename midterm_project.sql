CREATE DATABASE javamidterm COLLATE Chinese_Taiwan_Stroke_CI_AS;

Use javamidterm;

DROP TABLE if exists Institutions;

CREATE TABLE institutions (
    id BIGINT IDENTITY(1,1) PRIMARY KEY, -- 流水號 (主鍵)
    institutionname NVARCHAR(255), -- 機構名稱
    institutioncode NVARCHAR(20), -- 機構代碼
    address NVARCHAR(255), -- 地址全址
    serviceitems NVARCHAR(255), -- 特約服務項目
    phone NVARCHAR(50), -- 機構電話
    email NVARCHAR(255), -- 電子郵件
    managername NVARCHAR(50), -- 機構負責人姓名
    contractstartdate DATE, -- 特約起日
    contractenddate DATE, -- 特約迄日
    lastmodifieddate DATE, -- 最後異動時
    createdby NVARCHAR(50), -- 資料建立者帳號
    createdat DATETIME, -- 資料建立時間
    modifiedby NVARCHAR(50), -- 資料修改者帳號
    modifiedat DATETIME -- 資料修改時間
);

DROP TABLE if exists  Accounts;

CREATE TABLE accounts (
    id BIGINT IDENTITY(1,1) PRIMARY KEY, -- 流水號 (主鍵)
    account NVARCHAR(50), -- 帳號
    password NVARCHAR(255), -- 密碼
    createdby NVARCHAR(50), -- 資料建立者帳號
    createdat DATETIME,  -- 資料建立時間
    modifiedby NVARCHAR(50), -- 資料修改者帳號
    modifiedat DATETIME -- 資料修改時間
);

INSERT INTO Institutions (InstitutionName, InstitutionCode, Address, ServiceItems, Phone, Email, ManagerName, ContractStartDate, ContractEndDate, LastModifiedDate, CreatedBy, CreatedAt, ModifiedBy, ModifiedAt)
VALUES
(N'高雄市同愛社會福利關懷協會', '1N1500001', N'高雄市新興區復橫一路242號2樓', N'居家服務', '07-2155211', '3800951@gmail.com', N'覃馨儀', '2023-01-01', '2024-06-30', '2023-12-18', 'admin1', GETDATE(), 'editor1', GETDATE()),
(N'幸福家園社會服務中心', '1N1500002', N'台中市南屯區大墩路88號', N'居家服務', '04-1234567', 'happyhome@gmail.com', N'張三', '2023-02-01', '2024-05-30', '2023-12-17', 'admin2', GETDATE(), 'editor2', GETDATE()),
(N'安康照護機構', '1N1500003', N'新北市板橋區文化路66號', N'居家服務', '02-8765432', 'ankang@gmail.com', N'李四', '2023-03-01', '2024-06-15', '2023-12-15', 'admin3', GETDATE(), 'editor3', GETDATE()),
(N'溫馨長照中心', '1N1500004', N'台北市中正區信義路100號', N'居家服務', '02-9876543', 'wenxin@gmail.com', N'王五', '2023-01-15', '2024-06-10', '2023-12-12', 'admin4', GETDATE(), 'editor4', GETDATE()),
(N'健康之路機構', '1N1500005', N'高雄市左營區自由路55號', N'居家服務', '07-5432167', 'healthroad@gmail.com', N'趙六', '2023-02-20', '2024-06-20', '2023-12-14', 'admin5', GETDATE(), 'editor5', GETDATE()),
(N'愛心社會關懷機構', '1N1500006', N'桃園市中壢區元化路22號', N'居家服務', '03-8765432', 'lovecare@gmail.com', N'吳七', '2023-01-10', '2024-06-25', '2023-12-16', 'admin6', GETDATE(), 'editor6', GETDATE()),
(N'陽光長照服務中心', '1N1500007', N'花蓮市中山路99號', N'居家服務', '03-5432198', 'sunshinecare@gmail.com', N'陳八', '2023-03-05', '2024-06-05', '2023-12-19', 'admin7', GETDATE(), 'editor7', GETDATE()),
(N'長春社會服務中心', '1N1500008', N'新竹市東大路100號', N'居家服務', '03-4567890', 'evergreen@gmail.com', N'楊九', '2023-02-25', '2024-05-30', '2023-12-20', 'admin8', GETDATE(), 'editor8', GETDATE()),
(N'幸福長照協會', '1N1500009', N'台南市北區公園路88號', N'居家服務', '06-3214567', 'happylife@gmail.com', N'郭十', '2023-01-20', '2024-06-15', '2023-12-13', 'admin9', GETDATE(), 'editor9', GETDATE()),
(N'和諧家園服務中心', '1N1500010', N'嘉義市文化路50號', N'居家服務', '05-7891234', 'harmonyhome@gmail.com', N'許十一', '2023-03-10', '2024-06-10', '2023-12-11', 'admin10', GETDATE(), 'editor10', GETDATE());

INSERT INTO Accounts (Account, Password, CreatedBy, CreatedAt, ModifiedBy, ModifiedAt)
VALUES
('user1', 'password1', 'admin1', GETDATE(), 'editor1', GETDATE()),
('user2', 'password2', 'admin2', GETDATE(), 'editor2', GETDATE()),
('user3', 'password3', 'admin3', GETDATE(), 'editor3', GETDATE()),
('user4', 'password4', 'admin4', GETDATE(), 'editor4', GETDATE()),
('user5', 'password5', 'admin5', GETDATE(), 'editor5', GETDATE()),
('user6', 'password6', 'admin6', GETDATE(), 'editor6', GETDATE()),
('user7', 'password7', 'admin7', GETDATE(), 'editor7', GETDATE()),
('user8', 'password8', 'admin8', GETDATE(), 'editor8', GETDATE()),
('user9', 'password9', 'admin9', GETDATE(), 'editor9', GETDATE()),
('user10', 'password10', 'admin10', GETDATE(), 'editor10', GETDATE());

