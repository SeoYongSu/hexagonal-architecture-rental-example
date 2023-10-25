package com.example.rent.adapter.out.external.product;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;

/**
 * 레디스 이벤트 발행 예시
 */
@RequiredArgsConstructor
public class ProductEventPublisher {

    private final ReactiveStringRedisTemplate redisTemplate;

    public void publishEvent(String message) {
        redisTemplate.convertAndSend("eventChannel", message).subscribe();
    }
}
