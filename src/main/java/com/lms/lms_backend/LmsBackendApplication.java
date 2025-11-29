package com.lms.lms_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LmsBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LmsBackendApplication.class, args);
    }

    // needed for external servlet container (Tomcat) to initialize the app
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LmsBackendApplication.class);
    }
}