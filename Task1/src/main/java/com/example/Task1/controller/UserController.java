package com.example.Task1.controller;

import com.example.Task1.entity.User;
import com.example.Task1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String hello(){
        return "hello";
    }
    @PostMapping("/add")
    public Mono<User> addUser(@RequestBody User user){
        //User user=new User(id,userName);
        return userRepository.save(user);
    }

    @GetMapping("/showAll")
    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable int id){
        return userRepository.deleteById(id);
    }
}
