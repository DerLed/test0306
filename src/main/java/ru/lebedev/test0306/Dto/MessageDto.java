package ru.lebedev.test0306.Dto;

public class MessageDto {
    private String textMessage;

    public MessageDto(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}
