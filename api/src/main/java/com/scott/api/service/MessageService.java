package com.scott.api.service;

import com.scott.api.domain.Message;
import com.scott.api.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Page<Message> getMessages(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }

    public Message getMessage(String id) {
        return messageRepository.findById(id);
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message createMessage(String message) {
        Message newMessage = Message.builder()
                .message(message)
                .build();
        return messageRepository.save(newMessage);
    }

}
