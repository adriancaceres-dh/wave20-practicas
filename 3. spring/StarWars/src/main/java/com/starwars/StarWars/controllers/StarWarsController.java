package com.starwars.StarWars.controllers;


import com.starwars.StarWars.dto.PersonajeDTO;
import com.starwars.StarWars.services.StarWarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {
    @Autowired
    private StarWarsServices starWarsServices;


    @GetMapping("/personaje/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> findPersonajeByname(@PathVariable String nombre){
        return new ResponseEntity<>(starWarsServices.encontrarPersonaje(nombre), HttpStatus.OK);

    }

}
