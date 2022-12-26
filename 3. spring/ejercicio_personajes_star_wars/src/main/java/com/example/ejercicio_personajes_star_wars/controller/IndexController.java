package com.example.ejercicio_personajes_star_wars.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/findPersonaje/{name}")
    public ResponseEntity findByName(@PathVariable String name){

    }
}
