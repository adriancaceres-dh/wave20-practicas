package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    @GetMapping("{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes (@PathVariable String name){
        return new ResponseEntity<>(personajeService.getPersonajesByName(name), HttpStatus.OK);
    }

}
