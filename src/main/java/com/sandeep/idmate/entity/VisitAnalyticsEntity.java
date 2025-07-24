package com.sandeep.idmate.entity;

import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "visit_analytics")
public class VisitAnalyticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long analyticsId;

    @CreationTimestamp
    private Timestamp visitTime;

    private String ipAddress;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private CardEntity card;
}
