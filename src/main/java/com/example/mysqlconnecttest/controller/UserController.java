package com.example.mysqlconnecttest.controller;

import com.example.mysqlconnecttest.model.Users;
import com.example.mysqlconnecttest.repository.UserMysqlRepository;
import com.example.mysqlconnecttest.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {
    /*
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public Users create(@RequestBody Users users) {
        log.debug("create() 호출됨 = {}", users.getUserid());
        return userRepository.save(users);
    }

    @GetMapping("/user/{id}")
    public String read(@PathVariable Long id) {
        log.debug("read() 호출됨 = {}", id);
        Optional<Users> userOptional = userRepository.findById(id);
        userOptional.ifPresent(System.out::println);

        return "successfully executed";
    }
    */

    @Autowired
    private UserMysqlRepository userRepository;

    @PostMapping("/user")
    public void create(@RequestBody Users users) {
        log.debug("create() 호출됨 = {}", users.getUserid());
        userRepository.save(users);
    }

    @GetMapping("/user/{id}")
    public String read(@PathVariable Long id) {
        log.debug("read() 호출됨 = {}", id);
        Users users = userRepository.findById(id);
        if(users != null) {
            System.out.println(users.getName());
        }
        return "successfully executed";
    }

}
