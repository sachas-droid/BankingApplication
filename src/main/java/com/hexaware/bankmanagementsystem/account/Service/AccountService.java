package com.hexaware.bankmanagementsystem.account.Service;

import com.hexaware.bankmanagementsystem.account.exeptionHandler.AccountNotFoundException;
import com.hexaware.bankmanagementsystem.account.entity.Account;
import com.hexaware.bankmanagementsystem.account.model.AccountModel;
import com.hexaware.bankmanagementsystem.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
//Get list of all accounts for a User
    public List<Account> getAccountsByUser(Long userId) {
        return accountRepository.findByUserId(userId);
    }

//Get Account number by providing Account number
    public Account getAccountByNumber(String accountNumber) throws AccountNotFoundException {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Account not found: " +accountNumber));
    }

// Create an account
    public Account createAccount(AccountModel model) {
        Account entity  = Account.builder()
                .accountNumber(model.getAccountNumber())
                .accountType(model.getAccountType())
                .balance(model.getBalance())
                .primaryAccount(model.isPrimaryAccount())
                .userId(model.getUserId())
                .build();
        return accountRepository.save(entity);
    }

//Make account as Primary
    public Account makePrimary(String accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        account.setPrimaryAccount(true);
        return accountRepository.save(account);
    }

 // Delete an Account
    public void deleteAccount(String accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        accountRepository.delete(account);
    }
}
