package com.scott.sourceProducer.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class MessageProducer {

    @Value("${jobs.message.topic}")
    private String topic;

    private boolean sendingMessages = true;

    @Autowired
    private KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendMessage() {

        if (sendingMessages) {
            String randomMessage = generateRandomString();
            log.info("Sending message {}", randomMessage);
            kafkaTemplate.send(topic, randomMessage);
        }
    }

    private String generateRandomString() {

        String randomStringDomainCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int randomStringSize = 32;
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();

        while (randomString.length() < randomStringSize) {
            int index = (int) (random.nextFloat() * randomStringDomainCharacters.length());
            randomString.append(randomStringDomainCharacters.charAt(index));
        }

        return randomString.toString();
    }

    public boolean toggleSendingMessages() {
        sendingMessages = !sendingMessages;
        log.info("Toggled sending messages to {}", sendingMessages);
        return sendingMessages;
    }

    public boolean isSendingMessages() {
        return sendingMessages;
    }
}
