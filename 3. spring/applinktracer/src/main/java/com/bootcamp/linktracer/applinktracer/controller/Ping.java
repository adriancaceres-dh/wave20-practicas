package com.bootcamp.linktracer.applinktracer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {

    @GetMapping("/ping")
    public String Ping(){
        return "Pong";
    }
}
