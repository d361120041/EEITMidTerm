package tw.danielchiang.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tw.danielchiang.domain.Institution;
import tw.danielchiang.repository.InstitutionRepository;

@Service
@Transactional
public class InstitutionService {

	@Autowired
	private InstitutionRepository institutionRepository;

	// 查詢方法
	public List<Institution> select(Institution institution) {
		if (institution == null) {
			return institutionRepository.findAll(); // 若無條件則返回全部資料
		}

		if (institution.getId() != null) {
			Optional<Institution> result = institutionRepository.findById(institution.getId());
			return result.map(Collections::singletonList).orElse(Collections.emptyList()); // 若主鍵匹配，返回單筆結果
		}

		return institutionRepository.findAll(); // 預設返回所有資料
	}

	// 插入方法
	public Institution insert(Institution institution) {
		if (institution != null && institution.getId() == null) {
			
			// 新增時自動填入新增時間
			institution.setCreatedat(LocalDateTime.now());
			
			Institution insert = institutionRepository.save(institution); // 插入新資料
			return insert;
		}
		return null; // institution為null，返回 null
	}

	// 更新方法
	public Institution update(Institution institution) {
		if (institution != null && institution.getId() != null) {
			if (institutionRepository.existsById(institution.getId())) { // 確認資料是否存在
				
				// 如果資料庫已經有這筆資料，則建立者與建立時間不可更新
				Optional<Institution> optional = institutionRepository.findById(institution.getId());
				Institution temp = optional.get();
				institution.setCreatedby(temp.getCreatedby());
				institution.setCreatedat(temp.getCreatedat());
				
				// 自動更新修改時間
				institution.setModifiedat(LocalDateTime.now());
				
				Institution update = institutionRepository.save(institution); // 更新資料
				update.setModifiedat(LocalDateTime.now());
				return update;
			}
			return null; // 若資料不存在，返回 null
		}
		return null; // 更新失敗，返回 null
	}

	// 刪除方法
	public boolean delete(Institution institution) {
		if (institution != null && institution.getId() != null) {
			if (institutionRepository.existsById(institution.getId())) { // 確認資料是否存在
				institutionRepository.delete(institution); // 刪除資料
				return true; //  刪除成功，返回 true
			}
		}
		return false; // 刪除失敗，返回 false
	}

}
