package com.sandeep.idmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.idmate.entity.VisitAnalyticsEntity;

@Repository
public interface VisitAnalyticsRepository extends JpaRepository<VisitAnalyticsEntity, Long> {
    List<VisitAnalyticsEntity> findByCard_CardId(Long cardId);
}
