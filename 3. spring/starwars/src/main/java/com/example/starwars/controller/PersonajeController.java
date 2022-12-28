package com.example.starwars.controller;
import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    @Autowired
    IPersonajeService personajeService;

    @GetMapping("/personajes/{nombre}")
    ResponseEntity<List<PersonajeDTO>> getPersonajesPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(personajeService.obtenerPersonajesPorNombre(nombre));
    }
}

