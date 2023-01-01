package com.bootcamp.Covid_19.controller;

import com.bootcamp.Covid_19.dto.PersonaEnRiesgoDTO;
import com.bootcamp.Covid_19.dto.SintomaDTO;
import com.bootcamp.Covid_19.models.Persona;
import com.bootcamp.Covid_19.services.PersonaService;
import com.bootcamp.Covid_19.services.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/test")
    public ResponseEntity<List<Persona>> getAll(){
        return new ResponseEntity<List<Persona>>(personaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonaEnRiesgoDTO>> getPersonasRiesgo(){
        return new ResponseEntity<>(personaService.getPersonasEnRiesgo(), HttpStatus.OK);
    }

}
