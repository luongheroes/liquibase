package com.sample.example.controller;

import com.sample.example.service.ProducerService;
import lombok.AllArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/kafka")
public class KafkaSampleController {

    private final ProducerService producer;

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String data) {
        this.producer.sendMessage(data);
    }

    @PutMapping(value = "/push/person/{id}")
    public void sendPersonKafkaTopic(@Validated @PathVariable("id") Long id) throws NotFoundException {
        this.producer.sendMessagePerson(id);
    }
}
