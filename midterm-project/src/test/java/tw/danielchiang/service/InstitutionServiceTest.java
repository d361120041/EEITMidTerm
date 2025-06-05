package tw.danielchiang.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tw.danielchiang.domain.Institution;

@SpringBootTest
class InstitutionServiceTest {

	@Autowired
	private Institution institution;

	@Autowired
	private InstitutionService institutionService;

//	@Test
	void testSelect() {
		Institution nullQuery = null;
		List<Institution> nullResults = institutionService.select(nullQuery);
		System.out.println("nullResults: " + nullResults);

		Institution query = new Institution();
		query.setId(1L); // 設定查詢條件為 ID = 1
		List<Institution> results = institutionService.select(query);
		System.out.println("results: " + results);

		Institution noneQuery = new Institution();
		query.setId(100L); // 設定查詢條件為 ID = 100
		List<Institution> noneResults = institutionService.select(noneQuery);
		System.out.println("noneResults: " + noneResults);
	}
	
//	@Test
    public void testInsert() {
//        institution.setId(15L);
        institution.setInstitutionname("高雄市同愛社會福利關懷協會");
        institution.setInstitutioncode("1N1500001");
        institution.setAddress("高雄市新興區復橫一路242號2樓");
        institution.setServiceitems("居家服務");
        institution.setPhone("07-2155211");
        institution.setEmail("3800951@gmail.com");
        institution.setManagername("覃馨儀");
        institution.setContractstartdate(LocalDate.of(2023, 1, 1));
		institution.setContractenddate(LocalDate.of(2024, 6, 30));
		institution.setLastmodifieddate(LocalDate.of(2023, 12, 18));
		institution.setCreatedby("admin");
		institution.setCreatedat(LocalDateTime.of(2023, 1, 1, 10, 0, 0));
		institution.setModifiedby("admin");
		institution.setModifiedat(LocalDateTime.of(2023, 12, 18, 10, 0, 0));

		Institution insert = institutionService.insert(institution);
		System.out.println("insert=" + insert);
    }
	
//	@Test
	public void testUpdate() {
		institution.setId(7L);
		institution.setInstitutionname("高雄市同愛社會福利關懷協會");
		institution.setInstitutioncode("1N1500001");
		institution.setAddress("高雄市新興區復橫一路242號2樓");
		institution.setServiceitems("居家服務");
		institution.setPhone("07-2155211");
		institution.setEmail("3800951@gmail.com");
		institution.setManagername("覃馨儀");
		institution.setContractstartdate(LocalDate.of(2023, 1, 1));
		institution.setContractenddate(LocalDate.of(2024, 6, 30));
		institution.setLastmodifieddate(LocalDate.of(2023, 12, 18));
		institution.setCreatedby("admin");
		institution.setCreatedat(LocalDateTime.of(2023, 1, 1, 10, 0, 0));
		institution.setModifiedby("admin");
		institution.setModifiedat(LocalDateTime.of(2023, 12, 18, 10, 0, 0));

		Institution update = institutionService.update(institution);
		System.out.println("update=" + update);
	}
	
//	@Test
	public void testDelete() {
		institution.setId(11L);
	    boolean delete = institutionService.delete(institution);
	    System.out.println("delete=" + delete);
	}

	
////	@Test
//	void testSelect1() {
//		List<Institution> select = institutionService.select(null);
//		System.out.println("select=" + select);
//	}
//
////	@Test
//	void testSelect2() {
//		institution.setId(null);
//		List<Institution> select = institutionService.select(institution);
//		System.out.println("select=" + select);
//	}
//
////	@Test
//	void testSelect3() {
//		institution.setId(1L);
//		List<Institution> select = institutionService.select(institution);
//		System.out.println("select=" + select);
//	}
//
////	@Test
//	void testSelect4() {
//		institution.setId(11L);
//		List<Institution> select = institutionService.select(institution);
//		System.out.println("select=" + select);
//	}
//
//	@Test
//	void testInsert1() {
//		institution.setId(1L);
//		Institution insert = institutionService.insert(institution);
//		System.out.println("insert=" + insert);
//	}
//
////	@Test
//	void testInsert2() {
//		institution.setId(null);
//		Institution insert = institutionService.insert(institution);
//		System.out.println("insert=" + insert);
//	}
//
////	@Test
//	void testInsert3() {
//		institution.setId(null);
//		institution.setInstitutionName("高雄市同愛社會福利關懷協會");
//		institution.setInstitutionCode("1N1500001");
//		institution.setAddress("高雄市新興區復橫一路242號2樓");
//		institution.setServiceItems("居家服務");
//		institution.setPhone("07-2155211");
//		institution.setEmail("3800951@gmail.com");
//		institution.setManagerName("覃馨儀");
//		institution.setContractStartDate(LocalDate.of(2023, 1, 1));
//		institution.setContractEndDate(LocalDate.of(2024, 6, 30));
//		institution.setLastModifiedDate(LocalDate.of(2023, 12, 18));
//		institution.setCreatedBy("admin");
//		institution.setCreatedAt(LocalDateTime.of(2023, 1, 1, 10, 0, 0));
//		institution.setModifiedBy("admin");
//		institution.setModifiedAt(LocalDateTime.of(2023, 12, 18, 10, 0, 0));
//		Institution insert = institutionService.insert(institution);
//		System.out.println("insert=" + insert);
//	}
//
////	@Test
//	void testUpdate() {
//		institution.setId(10L);
//		institution.setInstitutionName("高雄市同愛社會福利關懷協會");
//		institution.setInstitutionCode("1N1500001");
//		institution.setAddress("高雄市新興區復橫一路242號2樓");
//		institution.setServiceItems("居家服務");
//		institution.setPhone("07-2155211");
//		institution.setEmail("3800951@gmail.com");
//		institution.setManagerName("覃馨儀");
//		institution.setContractStartDate(LocalDate.of(2023, 1, 1));
//		institution.setContractEndDate(LocalDate.of(2024, 6, 30));
//		institution.setLastModifiedDate(LocalDate.of(2023, 12, 18));
//		institution.setCreatedBy("admin");
//		institution.setCreatedAt(LocalDateTime.of(2023, 1, 1, 10, 0, 0));
//		institution.setModifiedBy("admin");
//		institution.setModifiedAt(LocalDateTime.of(2023, 12, 18, 10, 0, 0));
//		Institution update = institutionService.update(institution);
//		System.out.println("update=" + update);
//	}
//	
}
