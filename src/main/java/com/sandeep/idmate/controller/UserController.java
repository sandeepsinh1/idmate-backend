package com.sandeep.idmate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.idmate.dto.UserLoginDTO;
import com.sandeep.idmate.entity.UserEntity;
import com.sandeep.idmate.repository.UserRepository;
import com.sandeep.idmate.service.UserService;
@RestController
//@RestController is a specialized version of the @Controller annotation in Spring, used to build RESTful web services. It combines two annotations:@RestController = @Controller + @ResponseBody 
//Returns JSON/XML data directly to the frontend or Postman
//Automatically converts return values to HTTP responses
//Helps define and route HTTP requests to specific methods
@RequestMapping("/api/users")
// map HTTP requests to handler methods in controller classes.
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    UserLoginDTO userLoginDTO;
    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping("/login")
    public String LoginUser(@RequestBody UserLoginDTO user) {
    	Optional<UserEntity> user1 = userService.LoginUser(user); 

        if (user1.isPresent()) {
            return "login successfulll"; // Return full user object
        } else {
            return "Invalid Cradentail";
            		}}
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
