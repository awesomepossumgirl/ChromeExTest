package com.example.quickshortserver.repository;

import com.example.quickshortserver.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Long> {
    // 해시로 URL 조회
    Optional<ShortUrl> findByHash(String hash);
}
