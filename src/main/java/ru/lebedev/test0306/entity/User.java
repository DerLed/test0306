package ru.lebedev.test0306.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.lebedev.test0306.Dto.MessageDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Message> messages = new ArrayList<>();

    public List<MessageDto> messageToDto(){
        return messages.stream().map(f -> new MessageDto(f.getTextMessage())).collect(Collectors.toList());
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getMessageList() {
        return messages;
    }

    public void setMessageList(List<Message> messageList) {
        this.messages = messageList;
    }
}
