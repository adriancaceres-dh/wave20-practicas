package com.bootcamp.StarWars.controllers;

import java.util.List;
import com.bootcamp.StarWars.DTOs.PersonajeDTO;
import com.bootcamp.StarWars.services.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;
    @GetMapping("/all")
    public List<PersonajeDTO> obtenerPersonajes (){

        return personajeService.obtenerPersonajes();
    }

    @GetMapping("/{texto}")
    private ResponseEntity<List<PersonajeDTO>> obtenerPersonajesPorNombre(@PathVariable String texto){
        return ResponseEntity.accepted().
                header("hola que tal",texto).
                body(personajeService.obtenerPersonajesPorNombre(texto));
    }
}
