package org.example.consumer.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaComponent {

    @KafkaListener(topics = "${app.config.kafka.topic}", groupId = "${app.config.kafka.groupId}")
    public void consumerMessage(@Payload String message) {
        log.info("factory got message got {}", message);
    }
}
