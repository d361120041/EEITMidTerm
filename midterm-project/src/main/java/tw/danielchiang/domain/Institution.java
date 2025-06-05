package tw.danielchiang.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "institutions") // 資料表名稱也改為小寫
@Component
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 流水號 (主鍵)

    @Column(name = "institutionname")
    private String institutionname; // 機構名稱

    @Column(name = "institutioncode")
    private String institutioncode; // 機構代碼

    @Column(name = "address")
    private String address; // 地址全址

    @Column(name = "serviceitems")
    private String serviceitems; // 特約服務項目

    @Column(name = "phone")
    private String phone; // 機構電話

    @Column(name = "email")
    private String email; // 電子郵件

    @Column(name = "managername")
    private String managername; // 機構負責人姓名

    @Column(name = "contractstartdate")
    private LocalDate contractstartdate; // 特約起日

    @Column(name = "contractenddate")
    private LocalDate contractenddate; // 特約迄日

    @Column(name = "lastmodifieddate")
    private LocalDate lastmodifieddate; // 最後異動時

    @Column(name = "createdby")
    private String createdby; // 資料建立者帳號

    @Column(name = "createdat")
    private LocalDateTime createdat; // 資料建立時間

    @Column(name = "modifiedby")
    private String modifiedby; // 資料修改者帳號

    @Column(name = "modifiedat")
    private LocalDateTime modifiedat; // 資料修改時間

//    @PrePersist
//    protected void onCreate() {
//        if (modifiedat == null) {
//            modifiedat = LocalDateTime.now(); // 設定預設值為現在時間
//        }
//    }
//    
	public Institution() {
		super();
	}

	public Institution(Long id, String institutionname, String institutioncode, String address, String serviceitems,
			String phone, String email, String managername, LocalDate contractstartdate, LocalDate contractenddate,
			LocalDate lastmodifieddate, String createdby, LocalDateTime createdat, String modifiedby,
			LocalDateTime modifiedat) {
		super();
		this.id = id;
		this.institutionname = institutionname;
		this.institutioncode = institutioncode;
		this.address = address;
		this.serviceitems = serviceitems;
		this.phone = phone;
		this.email = email;
		this.managername = managername;
		this.contractstartdate = contractstartdate;
		this.contractenddate = contractenddate;
		this.lastmodifieddate = lastmodifieddate;
		this.createdby = createdby;
		this.createdat = createdat;
		this.modifiedby = modifiedby;
		this.modifiedat = modifiedat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstitutionname() {
		return institutionname;
	}

	public void setInstitutionname(String institutionname) {
		this.institutionname = institutionname;
	}

	public String getInstitutioncode() {
		return institutioncode;
	}

	public void setInstitutioncode(String institutioncode) {
		this.institutioncode = institutioncode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getServiceitems() {
		return serviceitems;
	}

	public void setServiceitems(String serviceitems) {
		this.serviceitems = serviceitems;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public LocalDate getContractstartdate() {
		return contractstartdate;
	}

	public void setContractstartdate(LocalDate contractstartdate) {
		this.contractstartdate = contractstartdate;
	}

	public LocalDate getContractenddate() {
		return contractenddate;
	}

	public void setContractenddate(LocalDate contractenddate) {
		this.contractenddate = contractenddate;
	}

	public LocalDate getLastmodifieddate() {
		return lastmodifieddate;
	}

	public void setLastmodifieddate(LocalDate lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public LocalDateTime getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public LocalDateTime getModifiedat() {
		return modifiedat;
	}

	public void setModifiedat(LocalDateTime modifiedat) {
		this.modifiedat = modifiedat;
	}

	@Override
	public String toString() {
		return "Institution [id=" + id + ", institutionname=" + institutionname + ", institutioncode=" + institutioncode
				+ ", address=" + address + ", serviceitems=" + serviceitems + ", phone=" + phone + ", email=" + email
				+ ", managername=" + managername + ", contractstartdate=" + contractstartdate + ", contractenddate="
				+ contractenddate + ", lastmodifieddate=" + lastmodifieddate + ", createdby=" + createdby
				+ ", createdat=" + createdat + ", modifiedby=" + modifiedby + ", modifiedat=" + modifiedat + "]";
	}

}
