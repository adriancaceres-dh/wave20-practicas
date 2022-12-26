package com.bootcamp.covid.controller;

import com.bootcamp.covid.dto.PersonaDTO;
import com.bootcamp.covid.model.Sintoma;
import com.bootcamp.covid.service.PersonaService;
import com.bootcamp.covid.service.SintomaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CovidController {

    private final SintomaService sintomaService;
    private final PersonaService personaService;

    public CovidController() {
        this.sintomaService = new SintomaService();
        this.personaService = new PersonaService();
    }

    @GetMapping ("/findSymptom")
    public ResponseEntity<List<Sintoma>> listarSintomas () {
        return ResponseEntity.ok().body(sintomaService.getAllSintomas());
    }

    @GetMapping ("/findSymptom/{nombre}")
    public ResponseEntity<Sintoma> buscarSintoma (@PathVariable String nombre) {
        Sintoma sintomaBuscado = sintomaService.getSintoma(nombre);
        if (Objects.isNull(sintomaBuscado)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sintomaBuscado);
    }

    @GetMapping ("/findRiskPerson")
    public ResponseEntity<List<PersonaDTO>> listarPersonasRiesgo () {
        return ResponseEntity.ok(personaService.listarPersonasDeRiesgo());
    }
}
