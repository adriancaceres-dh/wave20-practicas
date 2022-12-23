package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.service.DeporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    DeporteService deporteService = new DeporteService();

    @GetMapping("/findSports")
    public List<Deporte> buscarDeportes() {
        return deporteService.devolverTodosDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> buscarDeporte(@PathVariable String name) {
        return deporteService.devolverDeportePorNombre(name);
    }
}
