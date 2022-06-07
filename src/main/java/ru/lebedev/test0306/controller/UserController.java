package ru.lebedev.test0306.controller;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.test0306.entity.Message;
import ru.lebedev.test0306.entity.User;
import ru.lebedev.test0306.Dto.UserDto;
import ru.lebedev.test0306.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    List<UserDto> all(){
        return userRepository.findAll().stream().map(f ->
        {
            UserDto n = new UserDto();
            n.setName(f.getName());
            n.setMessages(f.messageToDto());
            return n;
        }
        ).collect(Collectors.toList());

    }

    @PostMapping("/users")
    @Fetch(FetchMode.SUBSELECT)
    public User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow();
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User replUser, @PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(replUser.getName());
                    user.setPassword(replUser.getPassword());
                    return userRepository.save(user);
                }).orElseGet(() -> {
                    replUser.setId(id);
                    return userRepository.save(replUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }


}
