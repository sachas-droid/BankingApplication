package com.hexaware.bankmanagementsystem.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Profile {
    @Id
    private Integer id;
}