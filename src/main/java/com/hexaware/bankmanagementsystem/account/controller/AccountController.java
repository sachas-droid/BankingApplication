package com.hexaware.bankmanagementsystem.account.controller;

import com.hexaware.bankmanagementsystem.account.Service.AccountService;
import com.hexaware.bankmanagementsystem.account.entity.Account;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // GET /api/v1/accounts?userId=123
    @GetMapping
    public List<Account> getAccounts(@RequestParam Long userId) {
        return accountService.getAccountsByUser(userId);
    }

    // GET /api/v1/accounts/{accountNumber}
    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }

    // POST /api/v1/accounts
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // PUT /api/v1/accounts/{accountNumber}/primary
    @PutMapping("/{accountNumber}/primary")
    public Account makePrimary(@PathVariable String accountNumber) {
        return accountService.makePrimary(accountNumber);
    }

    // DELETE /api/v1/accounts/{accountNumber}
    @DeleteMapping("/{accountNumber}")
    public void deleteAccount(@PathVariable String accountNumber) {
        accountService.deleteAccount(accountNumber);
    }
}

