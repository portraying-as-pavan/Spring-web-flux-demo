package com.example.h2demo.controller;

import com.example.h2demo.entity.Users;
import com.example.h2demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping(value = "/add")
    private Mono<Users> addUsers(@RequestBody Users users){
         return    usersRepository.save(users);
    }

    @GetMapping(value = "/showAll",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<Users> getAllUsers(){
        return  usersRepository.findAll();
    }

    @GetMapping(value = "/show/{id}")
    private Mono<Users> getUserById(@PathVariable int id){
        return usersRepository.findById(id);
    }
}
