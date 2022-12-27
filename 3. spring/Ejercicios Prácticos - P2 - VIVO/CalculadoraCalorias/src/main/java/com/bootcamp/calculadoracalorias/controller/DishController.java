package com.bootcamp.calculadoracalorias.controller;

import com.bootcamp.calculadoracalorias.dto.response.DishDto;
import com.bootcamp.calculadoracalorias.dto.response.FoodDto;
import com.bootcamp.calculadoracalorias.model.Dish;
import com.bootcamp.calculadoracalorias.service.DishService;
import com.bootcamp.calculadoracalorias.service.interfaces.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class DishController {

    @Autowired
    IDishService iDishService;

    @GetMapping("/totalCalorias")
    public ResponseEntity<Double> totalCaloriasPlato(@RequestParam String name, @RequestParam double weight) {
        return new ResponseEntity<>(iDishService.calcularTotalCalorias(name, weight), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<FoodDto>> listarIngredientes(@PathVariable String name) {
        return new ResponseEntity<>(iDishService.listarIngredientes(name), HttpStatus.OK);
    }

    @GetMapping("/masCalorias/{name}")
    public ResponseEntity<FoodDto> buscarIngredienteMasCalorias(@PathVariable String name) {
        return new ResponseEntity<>(iDishService.buscarIngredienteMasCalorias(name), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<DishDto>> listarPlatos() {
        return new ResponseEntity<>(iDishService.listarPlatos(), HttpStatus.OK);
    }
}
