package com.example.personaje.controller;

import com.example.personaje.dto.PersonajeDto;
import com.example.personaje.model.Personaje;
import com.example.personaje.service.IPersonajeService;
import com.example.personaje.service.PersonajeService;
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
    IPersonajeService iPersonajeService;
    @GetMapping("/personaje/{name}")
    public ResponseEntity<List<PersonajeDto>>findByName(@PathVariable String name){
        System.out.println("a" + iPersonajeService.findByName(name));
        return new ResponseEntity<>(iPersonajeService.findByName(name), HttpStatus.OK);

    }
}
