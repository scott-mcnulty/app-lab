package com.scott.api.controller;

import com.scott.api.domain.Message;
import com.scott.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public ResponseEntity getMessages(Pageable pageable) {
        return ResponseEntity.ok(messageService.getMessages(pageable));
    }

    @GetMapping("{messageId}")
    public ResponseEntity getMessage(@PathVariable(value = "messageId") String messageId) {
        return ResponseEntity.ok(messageService.getMessage(messageId));
    }

    @PostMapping
    public ResponseEntity createMesasge(@RequestBody Message message) {
        return ResponseEntity.ok(messageService.createMessage(message));
    }
}

