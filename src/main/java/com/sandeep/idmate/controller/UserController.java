package com.sandeep.idmate.controller;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.idmate.dto.UserDTO;
import com.sandeep.idmate.dto.UserLoginDTO;
import com.sandeep.idmate.entity.UserEntity;
import com.sandeep.idmate.repository.UserRepository;
import com.sandeep.idmate.security.JwtUtil;
import com.sandeep.idmate.service.UserService;
@RestController
//@RestController is a specialized version of the @Controller annotation in Spring, used to build RESTful web services. It combines two annotations:@RestController = @Controller + @ResponseBody 
//Returns JSON/XML data directly to the frontend or Postman
//Automatically converts return values to HTTP responses
//Helps define and route HTTP requests to specific methods
@RequestMapping("/api/users")
// map HTTP requests to handler methods in controller classes.

public class UserController {

    @Autowired
    private UserService userService;
  
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity user) {
        try {
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser(@RequestBody UserLoginDTO user) {
    	UserEntity user1 = userService.LoginUser(user); 
        if (user != null && user1.getPassword().equals(user.getPassword())) {
            String token = jwtUtil.generateToken(user1.getUserId());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        
        }
    
    @Autowired
    UserRepository userRepository;
    @GetMapping("/alluser")
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(u -> new UserDTO(u.getUserId(), u.getName(), u.getEmail()))
                .collect(Collectors.toList());
    }
    
}
