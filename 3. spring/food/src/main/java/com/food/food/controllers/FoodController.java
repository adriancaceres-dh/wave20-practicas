package com.food.food.controllers;

import com.food.food.dtos.Ingredient;
import com.food.food.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodController {


    @Autowired
    FoodService service;

    @GetMapping(path = "/ingredients")
    public List<Ingredient> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/ingredients/maxCalories")
    public Optional<Ingredient> findMaxCalories(){
        return service.findMaxCaloriesIng();
    }
}
