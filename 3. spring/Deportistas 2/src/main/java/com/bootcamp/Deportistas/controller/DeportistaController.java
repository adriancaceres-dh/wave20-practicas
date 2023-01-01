package com.bootcamp.Deportistas.controller;

import com.bootcamp.Deportistas.dto.DeportistaDTO;
import com.bootcamp.Deportistas.dto.PersonaDTO;
import com.bootcamp.Deportistas.model.Deporte;
import com.bootcamp.Deportistas.model.Persona;
import com.bootcamp.Deportistas.service.DeportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class DeportistaController {

    @Autowired
    DeportistaService deportistaService;
    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> getAllDeportes(){
        return new ResponseEntity<>(deportistaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getNivelDeporteByName(@PathVariable String name){

        return new ResponseEntity<>(deportistaService.getNivel(name), HttpStatus.OK);

    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<DeportistaDTO>> getDeportistas(){
        return new ResponseEntity<>(deportistaService.getDeportistas(),HttpStatus.OK);
    }
    @GetMapping("/All")
    public ResponseEntity<List<PersonaDTO>> getPeople(){
        return new ResponseEntity<>(deportistaService.getPeople(),HttpStatus.OK);
    }
}
