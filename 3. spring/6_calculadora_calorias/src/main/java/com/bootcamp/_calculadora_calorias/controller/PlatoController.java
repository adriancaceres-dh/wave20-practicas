package com.bootcamp._calculadora_calorias.controller;

import com.bootcamp._calculadora_calorias.dto.IngredienteDto;
import com.bootcamp._calculadora_calorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlatoController {

    @Autowired
    PlatoService platoService;

    @GetMapping("/platos/totalCalorias")
    public ResponseEntity<Double> calculateCalories(@RequestParam String name,
                                                     @RequestParam Double weight){
        return new ResponseEntity<>(platoService.calculateTotalCalories(name,weight), HttpStatus.OK);
    }

    @GetMapping("/platos/{name}")
    public ResponseEntity<List<IngredienteDto>> obtenerIngredientes(@PathVariable String name){
        return new ResponseEntity<>(platoService.obtenerIngredientes(name),HttpStatus.OK);
    }

    @GetMapping("/platos/valorCalorias")
    public ResponseEntity<IngredienteDto> obtenerIngredienteMasCalorico(@RequestParam String name){
        return new ResponseEntity<>(platoService.obtenerIngredienteMasCalorias(name),HttpStatus.OK);
    }

}
