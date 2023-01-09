package com.bootcamp.starwars.controller;

import com.bootcamp.starwars.dto.PersonajeDTO;
import com.bootcamp.starwars.entity.Personaje;
import com.bootcamp.starwars.mapper.Mapper;
import com.bootcamp.starwars.repository.IPersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonajeController {
    //@Autowired
    //private PersonajeService;

    @Qualifier("test")
    @Autowired
    private IPersonaje personajeService;

    //Constructor
    /*public PersonajeController(IPersonaje personajeService) {
        this.personajeService = personajeService;
    }

     */

    @GetMapping("/{nombre}")
    public ResponseEntity<List<PersonajeDTO>> encontrarPersonajeName(@PathVariable String nombre) {
        System.out.println("Nombre: " + nombre);
        List<PersonajeDTO> personajeDTOS = Mapper.mapToListPersonajeDto(personajeService.buscarPorNombre(nombre));
        return new ResponseEntity<>(personajeDTOS, HttpStatus.OK);

    }
}
