package com.bootcamp.appstarwars.controllers;

import com.bootcamp.appstarwars.dto.PersonajeDto;
import com.bootcamp.appstarwars.service.IPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personaje")
public class PersonajeController {

    @Autowired
    private IPersonajeService personajeService;

    @GetMapping("/{nombre}")
    public List<PersonajeDto> findByName(@PathVariable String nombre){
        return personajeService.find(nombre);
    }
}
