package ru.lebedev.test0306.controller;

import org.springframework.web.bind.annotation.*;
import ru.lebedev.test0306.entity.User;
import ru.lebedev.test0306.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    List<User> all(){
        return userRepository.findAll();
    }

    @PostMapping("/users")
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
