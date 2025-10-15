package com.hexaware.bankmanagementsystem.model;

public class User {
    private Integer userId;
    private String userName;
    private String userAddress;
    private String userPhoneNumber;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User(Integer userId, String userName, String userAddress, String userPhoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;

    }

    public User(com.hexaware.bankmanagementsystem.entity.User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.userAddress = user.getUserAddress();
        this.userPhoneNumber = user.getUserPhoneNumber();

    }
}