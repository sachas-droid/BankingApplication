package com.hexaware.bankmanagementsystem.account.model;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AccountModel {
    private String accountNumber;
    private String accountType;
    private double balance;
    private boolean primaryAccount;
    private Long userId;
}
