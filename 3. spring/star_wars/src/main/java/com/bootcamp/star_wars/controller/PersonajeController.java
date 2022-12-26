package com.bootcamp.star_wars.controller;

import com.bootcamp.star_wars.dto.PersonajeDTO;
import com.bootcamp.star_wars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {
    @Autowired
    IPersonajeService personajeService;

    @GetMapping(value= {"/personajes", "/personajes/{nombre}"})
    ResponseEntity<List<PersonajeDTO>> getPersonajesPorNombre(@PathVariable(required = false) String nombre) {
        return ResponseEntity.ok(personajeService.obtenerPersonajesPorNombre(nombre));
    }
}
