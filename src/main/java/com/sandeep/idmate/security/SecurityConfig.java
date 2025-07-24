package com.sandeep.idmate.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // ✅ This is the key part
            .authorizeHttpRequests()
            .requestMatchers("/**").authenticated()
            .and()
            .httpBasic(); // Enables Basic Auth

        return http.build();
    }
}
