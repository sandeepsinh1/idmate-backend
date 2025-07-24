package com.sandeep.idmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandeep.idmate.entity.SocialLinkEntity;

@Repository
public interface SocialLinkRepository extends JpaRepository<SocialLinkEntity, Long> {
    List<SocialLinkEntity> findByCard_CardId(Long cardId);
}
