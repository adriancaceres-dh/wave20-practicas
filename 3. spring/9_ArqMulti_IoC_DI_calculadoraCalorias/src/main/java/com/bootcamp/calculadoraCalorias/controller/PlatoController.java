package com.bootcamp.calculadoraCalorias.controller;

import com.bootcamp.calculadoraCalorias.model.Plato;
import com.bootcamp.calculadoraCalorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    @Autowired
    private PlatoService platoService;


    @GetMapping("/{nombre}")
    public ResponseEntity<Integer> calculateCantidadTotalCalorias(@PathVariable String nombre){
        return ResponseEntity.ok(platoService.totalPorPlato(nombre));
    }
}
