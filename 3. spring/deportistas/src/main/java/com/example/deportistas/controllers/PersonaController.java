package com.example.deportistas.controllers;

import com.example.deportistas.dtos.response.PersonaDeporteResponseDTO;
import com.example.deportistas.models.Persona;
import com.example.deportistas.services.PersonaService;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/personas")
    public ResponseEntity<String> addPersona(@RequestBody Persona persona) {
        personaService.addPersona(persona);
        return ResponseEntity.ok("Persona agregada");
    }

    @GetMapping("/findSportsPersons")
    public List<PersonaDeporteResponseDTO> getPersonasDeportistas() {
        return personaService.getPersonas()
                .stream()
                .map(persona -> new PersonaDeporteResponseDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNivel()))
                .collect(Collectors.toList());
    }
}
