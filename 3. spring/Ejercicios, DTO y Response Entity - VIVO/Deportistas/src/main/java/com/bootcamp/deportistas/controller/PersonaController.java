package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    PersonaService personaService = new PersonaService();
    @GetMapping("/findSportsPersons")
    public List<PersonaDTO> buscarDeportesPersonas(){
        return personaService.buscarDeportesPersonas();
    }
}
