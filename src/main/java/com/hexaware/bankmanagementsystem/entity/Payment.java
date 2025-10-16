package com.hexaware.bankmanagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;
import java.util.regex.Pattern;

@Entity
@Table(name = "payment")
public class Payment {
@Id
@Column
private Integer accountId;
private String userName;
private Integer paymentAmount;

//    private List<Payment> payments;
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Payment() {
    }
    public Payment(Integer accountId, String userName, Integer paymentAmount) {
        this.accountId = accountId;
        this.userName = userName;
        this.paymentAmount = paymentAmount;
    }

//        public List<Payment> getAllPayments(){ return payments; }
}
