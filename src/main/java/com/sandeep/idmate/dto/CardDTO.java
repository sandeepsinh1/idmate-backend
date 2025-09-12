package com.sandeep.idmate.dto;

import java.sql.Timestamp;

public class CardDTO {
    private Long cardId;
    private String title;
    private String userName;
    private Timestamp createdAt;

    public CardDTO(Long cardId, String title, String userName, Timestamp createdAt) {
        this.cardId = cardId;
        this.title = title;
        this.userName = userName;
        this.createdAt = createdAt;
    }

    // getters
    public Long getCardId() { return cardId; }
    public String getTitle() { return title; }
    public String getUserName() { return userName; }
    public Timestamp getCreatedAt() { return createdAt; }
}
