package com.bootcamp.prueba.controller;

import com.bootcamp.prueba.dto.PersonajeDto;
import com.bootcamp.prueba.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    private StarWarsService starWarsService;

    @Autowired
    public void setStarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }
    @GetMapping("/personajes/{name}")
    public List<PersonajeDto> getAllPersonajes(@PathVariable String name) {
        return starWarsService.getAllByName(name);
    }
}
