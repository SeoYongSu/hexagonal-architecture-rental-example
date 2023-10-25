package com.example.rent.config;

import com.example.rent.adapter.in.evnet.RedisMessageSubscriberExample;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class RedisConfig {

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    /**
     * 이벤트 리스너 Bean 등록
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(lettuceConnectionFactory());


        RedisMessageSubscriberExample myRedisMessageListener = new RedisMessageSubscriberExample();


        MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(myRedisMessageListener);
        container.addMessageListener(listenerAdapter, new ChannelTopic("Rental"));

        return container;
    }
}
