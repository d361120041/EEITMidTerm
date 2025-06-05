package tw.danielchiang.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.danielchiang.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByAccount(String account); // 根據帳號查找用戶
}
