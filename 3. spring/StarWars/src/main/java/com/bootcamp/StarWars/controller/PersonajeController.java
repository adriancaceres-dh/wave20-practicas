package com.bootcamp.StarWars.controller;

import com.bootcamp.StarWars.dto.PersonajeDTO;
import com.bootcamp.StarWars.repositories.PersonajeRepository;
import com.bootcamp.StarWars.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;
    @GetMapping("/findCharacter")
    public ResponseEntity<List<PersonajeDTO>> getCharacter(@RequestParam String name){
        return new ResponseEntity<List<PersonajeDTO>>(personajeService.getCharacter(name), HttpStatus.OK);
    }
}
