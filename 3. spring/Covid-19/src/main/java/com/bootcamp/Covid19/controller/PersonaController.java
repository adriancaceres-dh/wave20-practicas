package com.bootcamp.Covid19.controller;

import com.bootcamp.Covid19.dto.PersonaDTO;
import com.bootcamp.Covid19.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(){

        personaService = new PersonaService();
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> personasRiesgo(){
        return new ResponseEntity<>(personaService.encontrarPersona(), HttpStatus.OK);
    }

}
