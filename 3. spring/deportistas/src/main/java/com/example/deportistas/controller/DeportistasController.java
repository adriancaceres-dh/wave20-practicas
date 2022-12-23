package com.example.deportistas.controller;

import com.example.deportistas.dto.PersonaDeportistaDTO;
import com.example.deportistas.model.Deporte;
import com.example.deportistas.service.DeporteService;
import com.example.deportistas.service.PersonaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {
    DeporteService deporteService;
    PersonaService personaService;

    public DeportistasController() {
        this.deporteService = new DeporteService();
        this.personaService = new PersonaService();
    }

    @GetMapping("/findSports")
    List<Deporte> getDeportes() {
        return deporteService.obtenerDeportes();
    }


    @GetMapping("/findSport/{name}")
    ResponseEntity<Deporte> getDeporte(@PathVariable String name) {
        return deporteService.getDeporte(name)
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findSportsPersons")
    ResponseEntity<List<PersonaDeportistaDTO>> getDeportistas() {
        return new ResponseEntity<>(personaService.obtenerDeportistas(), HttpStatus.OK);
    }
}
