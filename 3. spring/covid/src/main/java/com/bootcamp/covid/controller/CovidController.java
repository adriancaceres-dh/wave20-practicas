package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.PersonaRiesgoDTO;
import com.bootcamp.covid.model.Sintoma;
import com.bootcamp.covid.service.PersonaService;
import com.bootcamp.covid.service.SintomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {
    SintomaService sintomaService;
    PersonaService personaService;

    public CovidController() {
        sintomaService = new SintomaService();
        personaService = new PersonaService();
    }

    @GetMapping("/findSymptom")
    List<Sintoma> getSintomas() {
        return sintomaService.getSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    ResponseEntity<Sintoma> getSintoma(@PathVariable String name) {
        return sintomaService.getSintoma(name)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/findRiskPerson")
    ResponseEntity<List<PersonaRiesgoDTO>> getPersonasRiesgo() {
        return new ResponseEntity<>(personaService.getPersonasRiesgo(), HttpStatus.OK);
    }
}
