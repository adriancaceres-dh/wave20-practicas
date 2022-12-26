package com.bootcamp.Deportistas.controller;

import com.bootcamp.Deportistas.model.Deporte;
import com.bootcamp.Deportistas.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/findSports")
public class DeporteController {
    private DeporteService deporteService;

    public DeporteController(){
        deporteService = new DeporteService();
    }

    @GetMapping()
    public List<Deporte> findSports(){
        return deporteService.findSports();
    }

    @GetMapping("/{findSport}")
    public ResponseEntity<String> findSport (@PathVariable String findSport){
        return deporteService.findSport(findSport);
    }
}
