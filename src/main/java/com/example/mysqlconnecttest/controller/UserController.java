package com.example.mysqlconnecttest.controller;

import com.example.mysqlconnecttest.model.Users;
import com.example.mysqlconnecttest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public Users create(@RequestBody Users users) {
        log.debug("create() 호출됨");
        return userRepository.save(users);
    }

    @GetMapping("/user/{id}")
    public String read(@PathVariable Long id) {
        log.debug("read() 호출됨");
        Optional<Users> userOptional = userRepository.findById(id);
        userOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
}
