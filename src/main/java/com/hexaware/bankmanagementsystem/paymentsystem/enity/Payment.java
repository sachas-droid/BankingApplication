package com.hexaware.bankmanagementsystem.paymentsystem.enity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
@Id
@Column(name = "account_no")
private Integer id;
private String user_name;
private Integer payment_amt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getPayment_amt() {
        return payment_amt;
    }

    public void setPayment_amt(Integer payment_amt) {
        this.payment_amt = payment_amt;
    }
    public Payment() {
    }
    public Payment(Integer id, String user_name, Integer payment_amt) {
        this.id = id;
        this.user_name = user_name;
        this.payment_amt = payment_amt;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", payment_amt=" + payment_amt +
                '}';
    }
}
