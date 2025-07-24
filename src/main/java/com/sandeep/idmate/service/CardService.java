package com.sandeep.idmate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sandeep.idmate.entity.CardEntity;
import com.sandeep.idmate.entity.UserEntity;
import com.sandeep.idmate.repository.CardRepository;
import com.sandeep.idmate.repository.UserRepository;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    public CardEntity createCard(CardEntity card, Long userId) {
        UserEntity user = userRepository.findById(userId).orElseThrow();
        card.setUser(user);
        return cardRepository.save(card);
    }

    public List<CardEntity> getCardsByUserId(Long userId) {
        return cardRepository.findByUser_UserId(userId);
    }

    public CardEntity getCardById(Long cardId) {
        return cardRepository.findById(cardId).orElseThrow();
    }

    public void deleteCard(Long cardId) {
        cardRepository.deleteById(cardId);
    }
}
