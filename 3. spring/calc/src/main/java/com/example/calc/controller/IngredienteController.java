package com.example.calc.controller;

import com.example.calc.model.Plato;
import com.example.calc.service.IIngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IngredienteController {

    @Autowired
    private IIngredienteService ingredienteService;

    @GetMapping("/{plato}/{peso}")
    public int mostrarPlato(@PathVariable String plato, @PathVariable int peso){
        return ingredienteService.calcularCalorias(plato, peso);
    }

}
