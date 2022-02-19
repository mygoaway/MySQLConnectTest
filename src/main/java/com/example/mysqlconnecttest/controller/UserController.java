package com.example.mysqlconnecttest.controller;

import com.example.mysqlconnecttest.model.Users;
import com.example.mysqlconnecttest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public Users create(@RequestBody Users users) {
        return userRepository.save(users);
    }

    @GetMapping("/user/{id}")
    public String read(@PathVariable Long id) {
        Optional<Users> userOptional = userRepository.findById(id);
        userOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}
