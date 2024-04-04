package org.example.producer.controller;

import lombok.RequiredArgsConstructor;

import org.example.producer.component.KafkaComponent;
import org.example.producer.model.ReportMessageModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaApplicationController {

    private final KafkaComponent kafkaComponent;

    @Value("${app.config.kafka.topic}")
    private String topic;

    @PostMapping("/api/v1/send")
    public String sendMessage(@RequestBody ReportMessageModel message) {
        this.kafkaComponent.send(topic, message.getMessage());

        return "ok";
    }
}
