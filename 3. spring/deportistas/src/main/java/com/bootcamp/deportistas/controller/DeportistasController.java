package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.response.DeporteResponseDto;
import com.bootcamp.deportistas.dto.response.DeportistaResponseDto;
import com.bootcamp.deportistas.service.DeportistasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportistasController {
    DeportistasService deportistasService = new DeportistasService();

    @GetMapping("/findSports")
    public List<DeporteResponseDto> mostrarDeportes() {
        return deportistasService.buscarDeportes();
    }

    @GetMapping("findSport/{nombre}")
    public DeporteResponseDto buscarDeporte(@PathVariable String nombre) {
        return deportistasService.buscarUnDeporte(nombre);
    }

    @GetMapping("/findSportsPersons")
    public List<DeportistaResponseDto> mostrarDeportistas() {
        return deportistasService.buscarDeportistas();
    }


}
