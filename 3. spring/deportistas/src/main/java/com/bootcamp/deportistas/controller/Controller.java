package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.service.Services;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private Services service;

    public Controller() {
        this.service = new Services();
    }

    @GetMapping("/findSports")
    public List<Deporte> obtenerDeportes(){
        return service.obtenerDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> obtenerDeporte(@PathVariable String name){
        String nivel = service.obtenerDeporteNivel(name);
        if(nivel == null){ return ResponseEntity.badRequest().body("Deporte no encontrado");}
        return ResponseEntity.ok().body("Nivel: " + nivel);
    }

    @GetMapping("/findSportsPersons")
    public List<PersonaDTO> obtenerDeportistas(){
        return service.obtenerDeportistas();
    }
}
