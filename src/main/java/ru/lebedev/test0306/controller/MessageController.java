package ru.lebedev.test0306.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lebedev.test0306.Dto.MessageDto;
import ru.lebedev.test0306.entity.Message;
import ru.lebedev.test0306.repository.MessageRepository;

import java.util.List;
@RestController
public class MessageController {
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }



//    @GetMapping("/messages")
//    List<Message> all(){
//        return messageRepository.findAll();
//    }
    @GetMapping("/messages")
    List<Message> userMessages(@RequestParam(required = false, name = "user_id") Long id){
        return messageRepository.findByUserId(id);
    }

}
