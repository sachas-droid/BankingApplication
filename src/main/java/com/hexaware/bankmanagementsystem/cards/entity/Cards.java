package com.hexaware.bankmanagementsystem.cards.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name ="Cards")
public class Cards {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private Integer cardNumber;

    @Column(name="Holder_NAME")
    private String name;

    @Column(name="EXP_DATE")
    private Date expDate;

    @Column(name="CVC")
    private Integer cvc;

    @Column(name="TYPE")
    private String type;

    @Column(nullable = false)
    private boolean primaryCard;

}
