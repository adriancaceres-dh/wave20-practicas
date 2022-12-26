package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.response.GrupoRiesgoResponseDto;
import com.bootcamp.covid.service.IPersonaService;
import com.bootcamp.covid.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    IPersonaService personaService;
    /*
    public PersonaController() {
        personaService = new PersonaService();
    }
    */

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<GrupoRiesgoResponseDto>> findRiskPerson() {
        return new ResponseEntity<>(personaService.grupoRiesgo(), HttpStatus.OK);
    }
}
