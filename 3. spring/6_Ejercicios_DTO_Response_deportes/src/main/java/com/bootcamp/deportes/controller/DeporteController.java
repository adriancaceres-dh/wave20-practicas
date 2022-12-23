package com.bootcamp.deportes.controller;

import com.bootcamp.deportes.model.Deporte;
import com.bootcamp.deportes.service.DeporteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    private DeporteService deporteService;

    public DeporteController() {
        deporteService = new DeporteService();
    }

    @GetMapping("/findSports")
    public List<Deporte> todosLosDeportes(){
        return deporteService.todosLosDeportes();
    }

    @GetMapping("/findSports/{name}")
    public String nivelPorDeporte(@PathVariable String name){
        return deporteService.nivelDeDeporte(name);
    }
}
