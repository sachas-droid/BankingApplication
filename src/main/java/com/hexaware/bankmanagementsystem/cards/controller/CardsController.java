package com.hexaware.bankmanagementsystem.cards.controller;

import com.hexaware.bankmanagementsystem.cards.entity.Cards;
import com.hexaware.bankmanagementsystem.cards.model.CardsModel;
import com.hexaware.bankmanagementsystem.cards.service.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.CardNotPresentException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/cards")
public class CardsController {
    private final CardsService cardsService;

    public CardsController(CardsService cardsService) {
        this.cardsService = cardsService;
    }

    @GetMapping
    public List<Cards> getCards(@RequestParam String name) {
        return cardsService.getCardsByName(name);
    }

    @GetMapping("/{cardNumber}")
    public Cards getCard(@RequestParam Integer cardNumber) {
        return cardsService.getCardsByCardNumber(cardNumber);
    }

    @PostMapping
    public Cards addCards(@RequestBody CardsModel cardsModel) {
        return cardsService.addCard(cardsModel);
    }

    @DeleteMapping("/{cardNumber}")
    public String deleteCard(@RequestParam Integer cardNumber) {
        return cardsService.deleteByCardNumber(cardNumber);
    }

    @PutMapping("/{cardNumber}")
    public Cards updateCard(@PathVariable Integer cardNumber) throws CardNotPresentException {
        return cardsService.updateCards(cardNumber);
    }
}
