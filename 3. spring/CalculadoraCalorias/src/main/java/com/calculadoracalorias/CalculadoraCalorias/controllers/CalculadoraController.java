package com.calculadoracalorias.CalculadoraCalorias.controllers;


import com.calculadoracalorias.CalculadoraCalorias.dto.FoodDto;
import com.calculadoracalorias.CalculadoraCalorias.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/findAllFood")
    public ResponseEntity<List<FoodDto>> findAllFood(){
        return new ResponseEntity<>(calculatorService.findAllFood(), HttpStatus.OK);
    }

}
