package com.hexaware.bankmanagementsystem.account.repository;

import com.hexaware.bankmanagementsystem.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByUserId(Long userId);

    Optional<Account> findByAccountNumber(String accountNumber);
}
