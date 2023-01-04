package com.bootcamp.test.controllers;
import com.bootcamp.test.dtos.PersonaDTO;
import com.bootcamp.test.dtos.SintomaDTO;
import com.bootcamp.test.model.NivelDeGravedad;
import com.bootcamp.test.services.CovidService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CovidController {

    @GetMapping("/findSymptom")
    public List<SintomaDTO> getSintomas() {
        return CovidService.getAllSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<NivelDeGravedad> nivelDeGravedad(@PathVariable String name) {
        NivelDeGravedad nivelDeGravedad = CovidService.getNivelDeGravedad(name);
        if (nivelDeGravedad == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(nivelDeGravedad);
    }

    @GetMapping("/findRiskPerson")
    public List<PersonaDTO> findRiskPerson() {
        return CovidService.getPersonasDeRiesgo();
    }

}