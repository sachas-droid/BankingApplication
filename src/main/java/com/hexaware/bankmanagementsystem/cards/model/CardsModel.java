package com.hexaware.bankmanagementsystem.cards.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CardsModel {
    private Integer id;
    private Integer number;
    private String name;
    private Date expDate;
    private Integer cvc;
    private String type;
    private boolean primaryCard;
}
