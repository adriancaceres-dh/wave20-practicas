package com.bootcamp.StarWars.controller;

import com.bootcamp.StarWars.Service.IPersonajeService;
import com.bootcamp.StarWars.dto.PersonajeDTO;
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
    private IPersonajeService personajeService;

    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(){
        return new ResponseEntity<>(personajeService.getPersonajes(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<PersonajeDTO>> getPersonajeByName(@PathVariable String name){
        return new ResponseEntity<>(personajeService.getPersonajesByName(name), HttpStatus.OK);
    }
}
