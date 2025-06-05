package tw.danielchiang.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.persistence.EntityManager;

@SpringBootTest
class InstitutionTest {

	@Autowired
	private EntityManager entityManager;
	
	@Test
	void testInstitution() {
		Institution find = entityManager.find(Institution.class, 1);
		System.out.println("find="+find);
	}

}
