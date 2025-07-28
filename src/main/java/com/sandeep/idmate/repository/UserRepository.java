package com.sandeep.idmate.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.sandeep.idmate.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE email = :email AND password = :password", nativeQuery = true)
    Optional<UserEntity> checkCredential(@Param("email") String email, @Param("password") String password);
}
