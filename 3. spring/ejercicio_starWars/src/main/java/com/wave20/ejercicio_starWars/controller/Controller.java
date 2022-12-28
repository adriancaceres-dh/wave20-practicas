package com.wave20.ejercicio_starWars.controller;

import com.wave20.ejercicio_starWars.dto.PersonajeDTO;
import com.wave20.ejercicio_starWars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    IPersonajeService personajeService;

    @GetMapping(value= {"/personajes", "/personajes/{nombre}"})
    ResponseEntity<List<PersonajeDTO>> getPersonajesPorNombre(@PathVariable(required = false) String nombre) {
        return ResponseEntity.ok(personajeService.obtenerPersonajesPorNombre(nombre));
    }
}
