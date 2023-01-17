package com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.controller;

import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.IngredientDTO;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.dto.PlateDTO;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.service.CalculatorService;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.service.IngredientService;
import com.bootcamp.calculadora_de_calorias.calculadora_de_calorias.service.PlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculatorController {
    @Autowired
    IngredientService ingredientService;
    @Autowired
    PlateService plateService;
    @GetMapping("/menu/ingredients")
    public ResponseEntity<List<IngredientDTO>> getAllIngredients(){
        return ResponseEntity.ok().body(ingredientService.getIngredients());
    }
    @GetMapping("/menu")
    public ResponseEntity<List<PlateDTO>> getAllPlates(){
        return ResponseEntity.ok().body(plateService.getPlates());
    }
    /*
    @PostMapping("/menu/plate")
    public ResponseEntity<List<PlateDTO>> postNewPlate(){
        return ResponseEntity.ok().body(postNewPlate());
    }

     */
}
