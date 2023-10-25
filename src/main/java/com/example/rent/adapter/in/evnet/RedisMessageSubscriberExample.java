package com.example.rent.adapter.in.evnet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisMessageSubscriberExample implements MessageListener {

    private final String EVENT_CHANNEL_NAME = "EXAMPLE";

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String messageBody = new String(message.getBody());
        System.out.println("Received message from channel " + channel + ": " + messageBody);
    }
}
