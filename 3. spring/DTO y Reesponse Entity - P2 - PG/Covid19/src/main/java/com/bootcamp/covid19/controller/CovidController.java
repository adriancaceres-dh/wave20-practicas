package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dto.GrupoRiesgoDTO;
import com.bootcamp.covid19.model.Persona;
import com.bootcamp.covid19.model.Sintoma;
import com.bootcamp.covid19.service.Servicios;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CovidController {

    Servicios servicios = new Servicios();

    @GetMapping("/findSymptom")
    public List<Sintoma> buscarSintomas() {
        return servicios.buscarSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> buscarSintomaPorNombre(@PathVariable String name) {
        return servicios.buscarSintomaPorNombre(name);
    }

    @GetMapping("/findRiskPerson")
    public List<GrupoRiesgoDTO> buscarPersonasGrupoRiesgo() {
        return servicios.buscarPersonasGrupoRiesgo();
    }
}
