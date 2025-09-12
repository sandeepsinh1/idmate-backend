package com.sandeep.idmate.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {
    private Long userId;
    private String name;
    private String email;
   
    public UserDTO()
    {}    
    public UserDTO(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // getters
    public Long getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
}
