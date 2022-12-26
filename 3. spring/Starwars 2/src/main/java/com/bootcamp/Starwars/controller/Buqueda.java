package com.bootcamp.Starwars.controller;

import com.bootcamp.Starwars.dto.PersonajeDTO;
import com.bootcamp.Starwars.repository.IPersonajesRepository;
import com.bootcamp.Starwars.service.IPersonajeService;
import com.bootcamp.Starwars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Buqueda {
    @Autowired
    PersonajeServiceImpl personajeService;
    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> buscarTodosPorNombre(@PathVariable String nombre){


        return new ResponseEntity<>(personajeService.buscarTodosPorNombre(nombre), HttpStatus.OK);
    }
}
