package com.example.ejercicio_deportistas.controllers;

import com.example.ejercicio_deportistas.dto.response.DeporteResponseDto;
import com.example.ejercicio_deportistas.dto.response.PersonaDeporteResponseDto;
import com.example.ejercicio_deportistas.service.DeporteService;
import com.example.ejercicio_deportistas.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
public class IndexController {

    DeporteService deporteService;
    PersonaService personaService;

    public IndexController() {
        this.deporteService = new DeporteService();
        personaService = new PersonaService();
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteResponseDto>> listDeportes(){
        return deporteService.findAll();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<DeporteResponseDto> encontrarPorNombre(@PathVariable String name){
        return deporteService.findByName(name);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDeporteResponseDto>> listarPersonasResumen(){
        return personaService.findAll();
    }

}
