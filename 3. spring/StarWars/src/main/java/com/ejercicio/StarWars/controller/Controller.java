package com.ejercicio.StarWars.controller;

import com.ejercicio.StarWars.dto.PersonaResponseDto;
import com.ejercicio.StarWars.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/findPersonaje")
public class Controller {

    private PersonaService personajeService;

    public Controller(){
        personajeService = new PersonaService();
    }

    @GetMapping("/{name}")
    public List<PersonaResponseDto> findByName(@PathVariable String name){
        System.out.println("Hola");
        return personajeService.findAll(name).stream().map(p->{return  new PersonaResponseDto(p.getName(),p.getHeight(),p.getMass(),p.getGender(),p.getHomeworld(),p.getSpecies());}).collect(Collectors.toList());
    }
}
