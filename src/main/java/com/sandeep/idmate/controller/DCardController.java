package com.sandeep.idmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.idmate.entity.CardEntity;
import com.sandeep.idmate.repository.CardRepository;

@RestController
@RequestMapping("/api/cards")
public class DCardController
 {

    @Autowired
    private CardRepository cardRepository;

    @PostMapping
    public ResponseEntity<String> createCard(@RequestBody CardEntity card) {
    	CardEntity saved = cardRepository.save(card);
        String url = "https://yourdomain.com/card/" + saved.getCardId();
        return ResponseEntity.ok(url);
    }
}
