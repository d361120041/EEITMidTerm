package tw.danielchiang.domain;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "accounts") // 資料表名稱也改為小寫
@Component
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 流水號 (主鍵)

    @Column(name = "account")
    private String account; // 帳號

    @Column(name = "password")
    private String password; // 密碼

    @Column(name = "createdby")
    private String createdby; // 資料建立者帳號

    @Column(name = "createdat")
    private LocalDateTime createdat; // 資料建立時間

    @Column(name = "modifiedby")
    private String modifiedby; // 資料修改者帳號

    @Column(name = "modifiedat")
    private LocalDateTime modifiedat; // 資料修改時間

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Account [id=" + id + ", account=" + account + ", password=" + password + ", createdby=" + createdby
				+ ", createdat=" + createdat + ", modifiedby=" + modifiedby + ", modifiedat=" + modifiedat + "]";
	}

}
