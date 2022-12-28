package com.bootcamp.blog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Ping {

    @Value("${spring.message}")
    private String message;
    @GetMapping("/ping")
    public String pong() {
        return "pong";
    }

    @GetMapping
    public String Hello(){
        return message;
    }
}
