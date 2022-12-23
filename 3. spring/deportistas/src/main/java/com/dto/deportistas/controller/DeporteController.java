package com.dto.deportistas.controller;

import com.dto.deportistas.service.DeporteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/deportes")
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
    public String leerUnDeporte(@PathVariable String name) {
        return deporteServicio.buscarDeporte(name);
    }

}
