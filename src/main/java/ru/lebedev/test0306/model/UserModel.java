package ru.lebedev.test0306.model;

import ru.lebedev.test0306.entity.Message;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private String name;
    private List<Message> messages = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
