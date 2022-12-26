package com.bootcamp.sistema.controller;

import com.bootcamp.sistema.model.Deporte;
import com.bootcamp.sistema.service.DeporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeporteController {

    DeporteService deporteService = new DeporteService();

    /*public DeporteController() {
        deporteService = new DeporteService();
    }*/

    @GetMapping("/findSports")
    public List<Deporte> devolverTodos(){
        return deporteService.devolverTodos();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> devolverPorNombre(@PathVariable String name){
        return deporteService.devolverPorNombre(name);
    }

}
