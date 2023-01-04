package com.example.demoarquitectura.controller;

import com.example.demoarquitectura.service.StarWarsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    private StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping(path = "/search/{name}")
    public ResponseEntity<List<String>> names(@PathVariable String name) {
        return new ResponseEntity<List<String>>(starWarsService.names(name), HttpStatus.OK);
    }

}
