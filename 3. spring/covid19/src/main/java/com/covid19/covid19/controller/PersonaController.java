package com.covid19.covid19.controller;

import com.covid19.covid19.dto.PersonaDTO;
import com.covid19.covid19.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    @Autowired
    PersonaService personaService;
    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> getPersonasRiesgo(){
        return personaService.getPersonasRiesgo();
    }
}
