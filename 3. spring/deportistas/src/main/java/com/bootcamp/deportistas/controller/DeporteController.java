package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.PersonaDeporteDTO;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.repository.DeporteRepository;
import com.bootcamp.deportistas.repository.IDeporteRepository;
import com.bootcamp.deportistas.service.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    @Autowired
    private IDeporteService iDeporteService;


    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getDeporte() {
        return new ResponseEntity<>(iDeporteService.getDeporte(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Deporte> getDeporteByName(@PathVariable String name) {
        return new ResponseEntity<>(iDeporteService.getDeporteByName(name), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteDTO>> list() {
        return new ResponseEntity<>(iDeporteService.getPersonaDeporte(), HttpStatus.OK);
    }
}
