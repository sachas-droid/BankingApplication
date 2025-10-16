package com.hexaware.bankmanagementsystem.account.Service;

import com.hexaware.bankmanagementsystem.account.entity.Account;
import com.hexaware.bankmanagementsystem.account.repository.AccountRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccountsByUser(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account makePrimary(String accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        account.setPrimaryAccount(true);
        return accountRepository.save(account);
    }

    public void deleteAccount(String accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        accountRepository.delete(account);
    }
}
