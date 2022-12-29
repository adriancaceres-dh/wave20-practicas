package com.bootcamp.sistema.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludo {

    @GetMapping
    public String saludar(){
        return "hola mundo";
    }

    @GetMapping("/saludar/{alguien}")
    public String saludarA(@PathVariable String alguien){
        return "Hola " + alguien;
    }

}
