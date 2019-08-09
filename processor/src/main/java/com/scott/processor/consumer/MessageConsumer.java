package com.scott.processor.consumer;

import com.scott.processor.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageConsumer {

    @Autowired
    private MessageService messageService;

    @KafkaListener(
            topics = "${processor.kafka.source-consumer.topic}",
            id = "${processor.kafka.source-consumer.id}")
    public void listen(String message) {
        log.info("Consumed message: {}", message);
        messageService.sendMessageToApi(message);
    }
}
