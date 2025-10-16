package com.hexaware.bankmanagementsystem.account.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    private String accountType;
    private double balance;
    private boolean primaryAccount;
    private Long userId;

    // Constructors
    public Account() {}

    public Account(String accountNumber, String accountType, double balance, boolean primaryAccount, Long userId) {

    }

    public void setPrimaryAccount(boolean b) {
    }

    // Getters and Setters
    // (Generate using your IDE)
}
