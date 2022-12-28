package com.bootcamp.CalculadoraCalorias.controller;

import com.bootcamp.CalculadoraCalorias.model.Ingrediente;
import com.bootcamp.CalculadoraCalorias.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping("/ingredientes")
    public ResponseEntity<List<Ingrediente>> getIngredientes(){
        return new ResponseEntity<>(ingredienteService.getIngredientes(), HttpStatus.OK);
    }
}
