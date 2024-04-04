package org.example.producer.component;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaComponent {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaComponent(@Qualifier("registerKafkaTemplate") KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(@NonNull String topic, @NonNull String message) {
        this.kafkaTemplate.send(topic, message)
                .whenComplete((result, err) -> {
                    if (err == null) {
                        log.info("kafka send to {} and value {}"
                                , result.getRecordMetadata().topic()
                                , result.getProducerRecord().value());
                    } else {
                        log.error("error: {}", err.getMessage());
                    }
                });
    }
}
