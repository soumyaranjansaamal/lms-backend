package com.lms.lms_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors() // use the CorsFilter bean we added
            .and()
            .csrf().disable() // safe for local dev + API testing
            .authorizeHttpRequests()
              .requestMatchers("/api/**").permitAll()
              .anyRequest().authenticated();

        return http.build();
    }
}
