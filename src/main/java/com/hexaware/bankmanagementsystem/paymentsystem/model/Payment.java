package com.hexaware.bankmanagementsystem.paymentsystem.model;

public class Payment {
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

    public Payment(Integer id, String user_name, Integer payment_amt) {
        this.id = id;
        this.user_name = user_name;
        this.payment_amt = payment_amt;
    }
}
