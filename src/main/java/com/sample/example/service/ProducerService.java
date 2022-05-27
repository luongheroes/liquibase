package com.sample.example.service;

import com.sample.example.model.PersonData;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class ProducerService {
    private static final String TOPIC = "users";
    private static final String TOPIC_PERSON = "person";

    private KafkaTemplate<String, String> kafkaTemplate;
    private ExampleService exampleService;

    // send data kafka
    public void sendMessage(String data) {
        log.info(String.format("#### -> Producing data -> %s", data));
        this.kafkaTemplate.send(TOPIC, data);
    }

    // send person kafka
    public void sendMessagePerson(Long id) throws NotFoundException {
        PersonData personData = exampleService.findById(id);
        if (Objects.isNull(personData)) {
            throw new NotFoundException("");
        }
        log.info(String.format("#### -> personData data -> %s", personData));
        this.kafkaTemplate.send(TOPIC_PERSON, String.valueOf(personData));
    }
}
