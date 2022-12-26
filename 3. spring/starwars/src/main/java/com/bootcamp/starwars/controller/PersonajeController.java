package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.PersonajeDto;
import com.bootcamp.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/personajes/{name}")
    public List<PersonajeDto> listPersonajes(@PathVariable String name) {
        return personajeService.findByName(name);
    }
}
