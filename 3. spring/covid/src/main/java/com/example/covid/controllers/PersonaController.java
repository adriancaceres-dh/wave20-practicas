package com.example.covid.controllers;

import com.example.covid.dtos.PersonaDto;
import com.example.covid.models.Persona;
import com.example.covid.services.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController() {
        personaService = new PersonaService();
    }

    @PostMapping("/person")
    public String addPerson(@RequestBody Persona persona) {
        return personaService.addPersona(persona);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDto> getPersonasConRiesgos() {
        return personaService.getRiskyPersons()
                .stream()
                .map(p -> new PersonaDto(p.getNombre(), p.getApellido()))
                .collect(Collectors.toList());
    }
}
