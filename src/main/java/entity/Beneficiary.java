package com.hexaware.beneficiary.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "beneficiary")
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "ifsc_code", nullable = false)
    private String ifscCode;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    // Default constructor (required by JPA)
    public Beneficiary() {
    }

    // Parameterized constructor
    public Beneficiary(int id, String name, String accountNumber, String ifscCode, String bankName) {
        this.id = id;
        this.name = name;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.bankName = bankName;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = Math.toIntExact(id);
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
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}