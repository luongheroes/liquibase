package com.sample.example.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ConsumerService {

    @KafkaListener(topics = "users", groupId = "groupId")
    public void consume(String data) {
        log.info(String.format("#### -> Consumed message -> %s", data));
    }
}
