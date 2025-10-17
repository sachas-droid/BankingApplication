package com.hexaware.bankmanagementsystem.account.controller;

import com.hexaware.bankmanagementsystem.account.Service.AccountService;
import com.hexaware.bankmanagementsystem.account.entity.Account;
import com.hexaware.bankmanagementsystem.account.model.AccountModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // GET /api/v1/accounts?
    @GetMapping
    public List<Account> getAccounts(@RequestParam Long userId) {
        return accountService.getAccountsByUser(userId);
    }

    // GET /api/v1/accounts/{accountNumber} account details
    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }

    // POST /api/v1/accounts
    @PostMapping
    public Account createAccount(@RequestBody AccountModel accountModel) {
        return accountService.createAccount(accountModel);
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

