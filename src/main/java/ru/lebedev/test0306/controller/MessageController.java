package ru.lebedev.test0306.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lebedev.test0306.entity.Message;
import ru.lebedev.test0306.repository.MessageRepository;

import java.util.List;
@RestController
public class MessageController {
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/messages")
    List<Message> all(){
        return messageRepository.findAll();
    }
}
