package ru.lebedev.test0306.Dto;

import ru.lebedev.test0306.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    private String name;
    private List<MessageDto> messages = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDto> messages) {
        this.messages = messages;
    }
}
