package com.example.covid.controllers;

import com.example.covid.models.Sintoma;
import com.example.covid.services.SintomaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class SintomaController {

    private final SintomaService sintomaService;

    public SintomaController() {
        sintomaService = new SintomaService();
    }

    @GetMapping("/findSymptom")
    public List<Sintoma> getAllSintomas() {
        return sintomaService.getAllSintomas();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<Sintoma> getSintomaByName(@PathVariable String name) {
        Sintoma sintoma = sintomaService.getSintoma(name);
        if(Objects.isNull(sintoma)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(sintoma);
    }
}
