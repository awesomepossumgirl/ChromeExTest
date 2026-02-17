package com.example.quickshortserver.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Table(name="short_urls")
public class ShortUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 8)
    private String hash;

    @Column(nullable = false)
    private String original;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    // 기본 생성자
    public ShortUrl() {
    }

    // 편한 생성자
    public ShortUrl(String hash, String original) {
        this.hash = hash;
        this.original = original;
    }

    // getter / setter


    public long getId() {
        return id;
    }
    public String getHash() {
        return hash;
    }
    public String getOriginal() {
        return original;
    }
    public LocalDateTime getCreateAt() {
        return createdAt;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    public void setOriginal(String original) {
        this.original = original;
    }
}
