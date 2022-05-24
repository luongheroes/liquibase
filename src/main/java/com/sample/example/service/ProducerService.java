package com.sample.example.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class ProducerService {
    private static final String TOPIC = "users";

    private KafkaTemplate<String, String> kafkaTemplate;

    // send data kafka
    public void sendMessage(String data) {
        log.info(String.format("#### -> Producing data -> %s", data));
        this.kafkaTemplate.send(TOPIC, data);
    }
}
