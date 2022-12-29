package com.bootcamp.contadorcalorias.controller;

import com.bootcamp.contadorcalorias.dto.IngredientDTO;
import com.bootcamp.contadorcalorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    DishService dishService;


    // Miercoles revisar con Adri.
    @GetMapping(value = {"/calories/{name}","/calories/{name}/{weight}"})
    public ResponseEntity<Integer> countCalories (@PathVariable String name, @PathVariable (required = false) Integer weight) {
        Integer totalCalories = dishService.countCalories(name,weight);
        // Arrojar excepcion desde el servicio para el caso de plato null.
        if(totalCalories == null) return new ResponseEntity<Integer>(0,HttpStatus.NOT_FOUND);
        return new ResponseEntity<Integer>(totalCalories, HttpStatus.OK);
    }

    @GetMapping(value = {"/ingredients/{name}","/ingredients/{name}/{weight}"})
    public ResponseEntity<List<IngredientDTO>> listIngredients (@PathVariable String name, @PathVariable (required = false) Integer weight) {
        return new ResponseEntity<List<IngredientDTO>>(dishService.listIngredients(name),HttpStatus.OK);
    }

    @GetMapping (value = {"/mostCaloricIngredient/{name}","/mostCaloricIngredient/{name}/{weight}"})
    public ResponseEntity<IngredientDTO> mostCaloricIngredient (@PathVariable String name, @PathVariable (required = false) Integer weight) {
        return new ResponseEntity(dishService.mostCaloricIngredient(name), HttpStatus.OK);
    }
}
