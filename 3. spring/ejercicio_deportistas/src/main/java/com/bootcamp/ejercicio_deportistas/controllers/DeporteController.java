package com.bootcamp.ejercicio_deportistas.controllers;

import com.bootcamp.ejercicio_deportistas.dtos.DeporteDTO;
import com.bootcamp.ejercicio_deportistas.services.interfaces.IDeporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    private IDeporteService deporteService;
    public DeporteController(IDeporteService deporteService){
        this.deporteService = deporteService;
    }

    @GetMapping(path = "/findSports")
    public List<DeporteDTO> findSports(){
        return deporteService.listarDesportes();
    }

    @GetMapping(path = "/findSports/{name}")

    public ResponseEntity<Integer> findSportByName(@PathVariable  String name){
         int res = deporteService.consultarDeporte(name);
         if(res >= 0){
             return ResponseEntity.ok(res);
         }else{
             return ResponseEntity.badRequest().body(res);
         }
    }
}
