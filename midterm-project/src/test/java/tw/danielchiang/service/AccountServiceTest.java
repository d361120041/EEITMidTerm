package tw.danielchiang.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.danielchiang.domain.Account;

@SpringBootTest
class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	@Test
	public void testLogin() {

		// 測試成功登入
		Account loggedInAccount = accountService.login("user1", "password1");
		System.out.println("loggedInAccount：" + loggedInAccount);

		// 測試帳號不存在
		Account nonexistentUser = accountService.login("nonexistentUser", "testPassword");
		System.err.println("nonexistentUser：" + nonexistentUser);

		// 測試密碼錯誤
		Account wrongPassword = accountService.login("testUser", "wrongPassword");
		System.err.println("wrongPassword：" + wrongPassword);

		// 測試空字串
		Account emptyString = accountService.login("", "");
		System.err.println("emptyString：" + emptyString);
	
		// 測試null
		Account nullValue = accountService.login(null, null);
		System.err.println("nullValue：" + nullValue);
		
	}

//	@Test
//	void testLogin1() {
//		Account login = accountService.login(null, null);
//		System.out.println("login="+login);
//	}
//
//	@Test
//	void testLogin2() {
//		Account login = accountService.login("1", "1");
//		System.out.println("login="+login);
//	}
//	
//	@Test
//	void testLogin3() {
//		Account login = accountService.login("", "");
//		System.out.println("login="+login);
//	}
//	
//	@Test
//	void testLogin4() {
//		Account login = accountService.login("1", "password1");
//		System.out.println("login="+login);
//	}
//	
}
