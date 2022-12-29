package com.DTOyResponseEntity.DTOyResponseEntity.controller;

import com.DTOyResponseEntity.DTOyResponseEntity.model.DTO.PersonaYDeporteDTO;
import com.DTOyResponseEntity.DTOyResponseEntity.service.DeporteService;
import com.DTOyResponseEntity.DTOyResponseEntity.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonaController {

    PersonaService personaService;
    DeporteService deporteService;

    public PersonaController() {
        personaService = new PersonaService();
        deporteService = new DeporteService();
    }

    @GetMapping("/findSportsPersons")
    public List<PersonaYDeporteDTO> encontrarPersonasDeportistas(){
        return personaService.getTodasLasPersonas().stream().map(persona -> new PersonaYDeporteDTO(persona.getNombre(),persona.getApellido(),persona.getDeporte().getNombre())).collect(Collectors.toList());
    }
}
