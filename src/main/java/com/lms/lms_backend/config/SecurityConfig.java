package com.lms.lms_backend.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Dev-friendly security configuration.
 *
 * IMPORTANT:
 * - This configuration is intentionally permissive (CSRF disabled, all requests permitted,
 *   permissive CORS) to make local API testing with curl/Postman simple.
 * - **Do not** use this in production. Protect endpoints and enable CSRF / proper auth in prod.
 */
@Configuration
public class SecurityConfig {

    /**
     * Main security filter chain.
     * For local development we:
     *  - enable CORS (using corsConfigurationSource() below)
     *  - disable CSRF (so POST/PUT/DELETE work easily with tools)
     *  - permit all requests (so you don't get 403 while developing)
     *
     * If you want to tighten security later, replace `.anyRequest().permitAll()` with
     * the appropriate authorization rules.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()                // use the CorsConfigurationSource bean defined below
            .csrf().disable()            // disabled for local/dev API testing
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()   // <-- dev: allow every request
            );

        return http.build();
    }

    /**
     * CORS configuration for development.
     * This allows requests from any origin and most common methods/headers.
     * Adjust origins and headers as needed.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cfg = new CorsConfiguration();

        // For quick local dev allow everything. Change these in production.
        cfg.setAllowedOrigins(Arrays.asList("*"));            // allow all origins (dev)
        cfg.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        cfg.setAllowedHeaders(Arrays.asList("*"));
        cfg.setAllowCredentials(true);
        cfg.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", cfg);
        return source;
    }
}