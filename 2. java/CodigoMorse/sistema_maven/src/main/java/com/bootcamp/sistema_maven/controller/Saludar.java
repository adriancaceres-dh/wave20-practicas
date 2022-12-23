package com.bootcamp.sistema_maven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludar {
    @GetMapping("/{name}")
    public String hola(@PathVariable String name) {
        return "Hola mundo"+ name ;
    }
}
