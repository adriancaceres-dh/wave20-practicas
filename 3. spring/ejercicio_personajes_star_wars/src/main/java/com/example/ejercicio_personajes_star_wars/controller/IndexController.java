package com.example.ejercicio_personajes_star_wars.controller;

import com.example.ejercicio_personajes_star_wars.dto.response.PersonajeResponseDto;
import com.example.ejercicio_personajes_star_wars.entity.Personaje;
import com.example.ejercicio_personajes_star_wars.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    PersonaService personaService;
    @GetMapping("/findPersonaje/{name}")
    public ResponseEntity<List<PersonajeResponseDto>> findByName(@PathVariable String name){

        return new ResponseEntity<>(personaService.findByName(name), HttpStatus.OK);

    }
}
