package com.bootcamp.appcalorias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {
    @GetMapping
    public String ping(){
        return "Pong";
    }
}
