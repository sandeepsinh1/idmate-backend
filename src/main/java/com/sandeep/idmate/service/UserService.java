package com.sandeep.idmate.service;

import org.springframework.stereotype.Service;

import com.sandeep.idmate.entity.UserEntity;
import com.sandeep.idmate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ Register a new user
    public UserEntity registerUser(UserEntity user) {
        Optional<UserEntity> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("User with this email already exists.");
        }
        user.setRole("USER");
        return userRepository.save(user);
    }

    // ✅ Get user by ID
    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // ✅ Get all users
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Delete user by ID
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
