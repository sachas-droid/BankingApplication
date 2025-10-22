package com.hexaware.bankmanagementsystem.account.exeptionHandler;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

