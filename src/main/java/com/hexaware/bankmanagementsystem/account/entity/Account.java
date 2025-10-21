package com.hexaware.bankmanagementsystem.account.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;
    @Column(nullable = false)
    private String accountType;
    private double balance;
    @Column(unique = true, nullable = false)
    private boolean primaryAccount;
    @Column(unique = true, nullable = false)
    private Long userId;

}