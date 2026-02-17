package com.example.quickshortserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.quickshortserver.model")
public class QuickShortServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickShortServerApplication.class, args);
    }

}
