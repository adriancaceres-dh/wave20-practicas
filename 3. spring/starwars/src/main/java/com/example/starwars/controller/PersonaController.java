package com.example.starwars.controller;

import com.example.starwars.DTO.PersonajeDTO;
import com.example.starwars.entity.Personaje;
import com.example.starwars.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    PersonajeService personajeService;
    @GetMapping("/personajes")
    public ResponseEntity<List<PersonajeDTO>> getPersonajes(@RequestParam(required = false) String nombre){
        if (nombre == null){
            return ResponseEntity.ok().body(personajeService.personajeDTOList());
        }else {
            return ResponseEntity.ok().body(personajeService.personajesFiltradosDTO(nombre));
        }
    }
}
