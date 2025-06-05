package tw.danielchiang.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tw.danielchiang.domain.Account;
import tw.danielchiang.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public Account login(String account, String password) {
		// 根據帳號查找 Account 資料
		Optional<Account> optionalAccount = accountRepository.findByAccount(account);

		// 驗證帳號是否存在以及密碼是否正確
		if (optionalAccount.isPresent()) {
			Account foundAccount = optionalAccount.get();
			if (foundAccount.getPassword().equals(password)) {
				return foundAccount; // 驗證成功，返回帳號資訊
			}
		}
		return null;
	}

}
