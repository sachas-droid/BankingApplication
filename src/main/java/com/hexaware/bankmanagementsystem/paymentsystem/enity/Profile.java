package com.hexaware.bankmanagementsystem.paymentsystem.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Profile {
    @Id
    private Long id;
}
