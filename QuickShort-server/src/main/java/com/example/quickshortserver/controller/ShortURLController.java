package com.example.quickshortserver.controller;

import com.example.quickshortserver.service.ShortUrlService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class ShortURLController {
    // 요청 받기, 서비스 호출, 결과 반환

    // 필드
    // 이 클래스는 무엇을 가지고 있나
    private final ShortUrlService shortUrlService;

    // 생성자
    // 그걸 어떻게 주입 받나
    public ShortURLController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    // 메서드
    // 그래서 무슨 일을 하나?
    @PostMapping("/api/shorten")
    public String shortenUrl(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("url");
        return shortUrlService.shorten(originalUrl);
    }
}
