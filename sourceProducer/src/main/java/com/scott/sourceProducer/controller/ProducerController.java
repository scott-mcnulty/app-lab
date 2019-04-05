package com.scott.sourceProducer.controller;

import com.scott.sourceProducer.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class ProducerController {

    @Autowired
    private MessageProducer messageProducer;

    @GetMapping("status")
    public ResponseEntity getProducerStatus() {
        return ResponseEntity.ok(messageProducer.isSendingMessages());
    }

    @PutMapping("toggle")
    public ResponseEntity toggleSendingMessages() {
        return ResponseEntity.ok(messageProducer.toggleSendingMessages());
    }
}
