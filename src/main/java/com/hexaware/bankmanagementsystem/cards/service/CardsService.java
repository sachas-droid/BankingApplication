package com.hexaware.bankmanagementsystem.cards.service;

import com.hexaware.bankmanagementsystem.cards.entity.Cards;
import com.hexaware.bankmanagementsystem.cards.model.CardsModel;
import com.hexaware.bankmanagementsystem.cards.model.CardsModel;
import com.hexaware.bankmanagementsystem.cards.repository.CardsRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.smartcardio.CardNotPresentException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CardsService {
    private final CardsRepository cardsRepository;

    public CardsService(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    public List<Cards> getCardsByName(String name) {
        return cardsRepository.findByName(name);
    }

    public Cards getCardsByCardNumber(Integer cardNumber) {
        return cardsRepository.findByCardNumber(cardNumber);

    }

    public Cards addCard(CardsModel model) {
        Cards entity = Cards.builder()
                .cardNumber(model.getNumber())
                .name(model.getName())
                .expDate((Date) model.getExpDate())
                .cvc(model.getCvc())
                .type(model.getType())
                .primaryCard(model.isPrimaryCard())
                .build();
        return cardsRepository.save(entity);
    }

    public String deleteByCardNumber(Integer cardNumber){
        cardsRepository.deleteAllById(cardNumber);
        return "Successfully deleted";
    }

    public Cards updateCards(Integer cardNumber) throws CardNotPresentException {
        Cards cards = getCardsByCardNumber(cardNumber);
        cards.setPrimaryCard(true);
        return cardsRepository.save(cards);
    }
}
