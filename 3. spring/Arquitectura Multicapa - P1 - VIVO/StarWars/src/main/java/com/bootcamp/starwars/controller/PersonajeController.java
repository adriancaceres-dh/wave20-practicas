package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.service.PersonajeService;
import com.bootcamp.starwars.dto.response.PersonajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    @GetMapping("/personajes")
    public List<PersonajeDTO> buscarTodos() {
        return personajeService.buscarTodos();
    }

    @GetMapping("/personaje")
    public List<PersonajeDTO> buscarPersonajePorNombre(@RequestParam String nombre) {
        return personajeService.buscarPersonajePorNombre(nombre);
    }
}
