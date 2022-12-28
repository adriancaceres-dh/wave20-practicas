package com.example.sintomas.controllers;

import com.example.sintomas.dtos.PersonaSintomaDto;
import com.example.sintomas.services.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/Person")

public class PersonaController {
    private static PersonaService _service = new PersonaService();
    @GetMapping("/findRiskPerson")
    public Collection<PersonaSintomaDto> getRiskPerson(){
        return _service.getPersonaConSintomas();
    }
}
