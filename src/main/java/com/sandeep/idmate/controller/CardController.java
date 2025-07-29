package com.sandeep.idmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.idmate.entity.CardEntity;
import com.sandeep.idmate.service.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    
    @PostMapping("/insertDetail")
    CardEntity createCard1(@RequestBody CardEntity card)
    {
    	return cardService.insertDetail(card);
    }
    
    @PostMapping("/create/{userId}")
    public ResponseEntity<CardEntity> createCard(@RequestBody CardEntity card, @PathVariable Long userId) {
        return ResponseEntity.ok(cardService.createCard(card, userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CardEntity>> getCardsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(cardService.getCardsByUserId(userId));
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardEntity> getCardById(@PathVariable Long cardId) {
        return ResponseEntity.ok(cardService.getCardById(cardId));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<String> deleteCard(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);
        return ResponseEntity.ok("Card deleted successfully");
    }
}
