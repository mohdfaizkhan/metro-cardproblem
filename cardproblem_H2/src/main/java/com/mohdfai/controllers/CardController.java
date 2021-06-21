package com.mohdfai.controllers;

import com.mohdfai.domain.CardEntity;
import com.mohdfai.interfaces.CardService;
import com.mohdfai.service.CardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/card")
public class CardController {

    private final CardService service;
    @Autowired
    public CardController(CardServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    @SuppressWarnings("unchecked")
    public ResponseEntity addNewCard (@RequestBody CardEntity cardEntity) {
        return new ResponseEntity(service.saveCardEntity(cardEntity), HttpStatus.OK);
    }

    @PutMapping
    @SuppressWarnings("unchecked")
    public ResponseEntity paymentToCard (@RequestParam Long cardId, Double payment) {
        return new ResponseEntity(service.paymentToCard(cardId, payment), HttpStatus.OK);
    }

}
