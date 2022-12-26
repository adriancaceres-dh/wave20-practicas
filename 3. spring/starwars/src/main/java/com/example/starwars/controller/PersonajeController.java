package com.example.starwars.controller;

import com.example.starwars.dto.PersonajeDto;
import com.example.starwars.service.PersonajeService;
import com.example.starwars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    private final PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService) {
        this.personajeService = personajeService;
    }

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDto>> getPersonajes(
        @RequestParam (required = false) String name
    ) {
        if ( name != null) {
            return ResponseEntity.ok().body(personajeService.getByName(name));
        }
        return ResponseEntity.ok().body(personajeService.getAll());
    }
}
