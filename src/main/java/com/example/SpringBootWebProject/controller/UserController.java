package com.example.SpringBootWebProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
