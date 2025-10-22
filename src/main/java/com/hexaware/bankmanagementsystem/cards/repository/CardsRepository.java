package com.hexaware.bankmanagementsystem.cards.repository;

import com.hexaware.bankmanagementsystem.cards.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Integer> {
    List<Cards> findByName(String name);
    Cards findByCardNumber(Integer cardNumber);
    void deleteAllById(Integer cardNumber);
}
