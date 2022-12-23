package com.bootcamp.ensayo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Saludo {

    @GetMapping()
    public String saludar(){
        return "Hola Mundo";
    }

    @GetMapping("/saludar/{nombre}")
    public String saludarA(@PathVariable String nombre){
        return "Hola " + nombre;
    }
}
