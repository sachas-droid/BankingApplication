package com.hexaware.bankmanagementsystem.model;

public class Beneficiary {
    private Long id;
    private String name;
    private String accountNumber;
    private String ifscCode;

    // --- Constructors ---
    public Beneficiary() {}
    public Beneficiary(Long id, String name, String accountNumber, String ifscCode) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
    }
    // --- Getters and Setters ---
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getIfscCode() {
        return ifscCode;
    }
    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }
}