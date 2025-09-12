package com.sandeep.idmate.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.idmate.dto.CardDTO;
import com.sandeep.idmate.entity.CardEntity;
import com.sandeep.idmate.repository.CardRepository;
import com.sandeep.idmate.service.CardService;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    
    @PostMapping("/insertDetail")
	/*
	 * CardEntity createCard1(@RequestBody CardEntity card) { return
	 * cardService.insertDetail(card); }
	 */
    public ResponseEntity<CardEntity> createCard1(@RequestBody CardEntity card, @RequestParam Long userId) {
        CardEntity savedCard = cardService.insertDetail(card, userId);
        return ResponseEntity.ok(savedCard);
    }
    
    @PostMapping("/create/{userId}")
    public ResponseEntity<CardEntity> createCard(@RequestBody CardEntity card, @PathVariable Long userId) {
        return ResponseEntity.ok(cardService.createCard(card, userId));
    }

    
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCardsByUser(@PathVariable Long userId) {
        try {
            List<CardEntity> cards = cardService.getCardsByUserId(userId);
            if (cards.isEmpty()) {
                // Manually throw an exception or return a 404
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No cards found for user with ID: " + userId);
            }
            return ResponseEntity.ok(cards);
        } catch (Exception e) {
            // Handle unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<?> getCardById2(@PathVariable Long cardId) {
        try {
            CardEntity card = cardService.getCardById(cardId);
            if (card == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found with ID: " + cardId);
            }
            return ResponseEntity.ok(card);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }


    @DeleteMapping("/{cardId}")
    public ResponseEntity<String> deleteCard(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);
        return ResponseEntity.ok("Card deleted successfully");
    }
    @GetMapping("getcard/{cardId}")
    public ResponseEntity<CardEntity> getCardById(@PathVariable Long cardId) {
        return ResponseEntity.ok(cardService.getCardById(cardId));
    }
    
    
    @Autowired
    CardRepository cardRepository;
    @GetMapping("/allcards")
    public List<CardDTO> getAllCards() {
        List<CardEntity> cards = cardRepository.findAll();
        return cards.stream()
                .map(c -> new CardDTO(
                        c.getCardId(),
                        c.getTitle(),
                        c.getName(),
                        c.getCreatedAt()
                ))
                .collect(Collectors.toList());
    }
   }
