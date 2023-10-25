package com.example.rent.adapter.out.external;

import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisEventPublisherExample {

    private final RedisTemplate<String, String> redisTemplate;
    private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    public RedisEventPublisherExample(RedisTemplate<String, String> redisTemplate, ReactiveRedisTemplate<String, String> reactiveRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.reactiveRedisTemplate = reactiveRedisTemplate;
    }

    public void publishEvent(String message) {
        redisTemplate.convertAndSend("eventChannel", message);
    }

    public void reactivePublishEvent(String message) {
        reactiveRedisTemplate.convertAndSend("eventChannel", message).subscribe();
    }
}
