package com.example.prueba1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Saludos")

public class Saludos {
    @GetMapping("/")
    public String Hola(){
        return "Hello world! :)";
    }

    @GetMapping("/hola")
    public String Hola(@RequestParam(value = "nombre", defaultValue = "")String nombre){
        return String.format("Hola %s! :)", nombre);
    }
}
