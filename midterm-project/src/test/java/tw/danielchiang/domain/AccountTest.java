package tw.danielchiang.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;

@SpringBootTest
class AccountTest {

	@Autowired
	private EntityManager entityManager;
	
	@Test
	void testAccount() {
		Account find = entityManager.find(Account.class, 1);
		System.out.println("find="+find);
	}

}
