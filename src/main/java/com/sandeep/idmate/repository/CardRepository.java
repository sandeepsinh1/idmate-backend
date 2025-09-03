package com.sandeep.idmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sandeep.idmate.entity.CardEntity;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {
    List<CardEntity> findByUser_UserId(Long userId);
    
    @Query(value = "SELECT * FROM cards WHERE phone = :phone", nativeQuery = true)
    CardEntity getCardDetails(@Param("phone") String phone);

}
