package com.example.quickshortserver.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShortUrlService {
    // URL 문자열을 받는다, 해시 코드 생성, 결과 문자열로 돌려주기
    // 일단 해시 로직 단순하게 UUID, hashCode(), 임시문자열 - 동작?
    // 그 다음 API가 실제로 호출되는지 테스트 curl / Postman / fetch(크롬)
    // 목표 : POST요청 → 서버 응답이 오는가?
    // 되면 해시 알고리즘 제대로 만들기 /api/{hash} 리다이렉트 API 추가
    // Map으로 중복 Url 처리 
    // DB(JPA) 연결
    // 한마디로 POST /api/shorten이 실제로 값 하나를 돌려준다
    // SHA-256 → 숫자로 변환 → Base62 인코딩 (UUID → 나중에 교체)
    public String shorten(String originalUrl) {
        // 임시 해시
        String hash = UUID.randomUUID().toString().substring(0, 8);

        return hash;
    }
}
