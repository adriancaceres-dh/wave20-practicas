package com.dto.deportistas.controller;

import com.dto.deportistas.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeporteController {
    DeporteService deporteServicio;

    public DeporteController() {
        deporteServicio = new DeporteService();
    }

    @GetMapping("findSports")
    public String leerDeportes() {
        return deporteServicio.toString();
    }

    @GetMapping("findSports/{name}")
    public ResponseEntity<String> leerUnDeporte(@PathVariable String name) {
        return new ResponseEntity<>(deporteServicio.buscarDeporte(name), HttpStatus.OK);
    }

}
