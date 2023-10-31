package com.example.SpringBootWebProject.controller;


import com.example.SpringBootWebProject.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class RestExample {

    @GetMapping("/helloworld")
    //@DeleteMapping("/helloworld")
    public ResponseEntity<String> helloWorld(){
        String s = "Hello, World!";
        return new ResponseEntity<>(s, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getuser")
    public User getUser(){
        User u = new User(1,"exp","korodi.marci@gmail.com","werw",
                "Kóródi Ferenc Marcell", LocalDate.of(2000,8,25));
        return u;
    }

}
