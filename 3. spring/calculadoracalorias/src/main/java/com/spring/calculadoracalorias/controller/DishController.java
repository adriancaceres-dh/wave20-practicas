package com.spring.calculadoracalorias.controller;

import com.spring.calculadoracalorias.dto.IngredentDTO;
import com.spring.calculadoracalorias.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    public IDishService iDishService;
    @GetMapping("/calories/{nameDish}")
    public ResponseEntity<Double> caloriesDish(@PathVariable String nameDish){
        return new ResponseEntity<>(iDishService.getCaloriesDish(nameDish), HttpStatus.OK);
    }

    @GetMapping("/ingredients/{nameDish}")
    public ResponseEntity<String> ingredientsCaloriesDish(@PathVariable String nameDish){
        return new ResponseEntity<>(iDishService.getIngredentsCaloriesDish(nameDish), HttpStatus.OK);
    }
    @GetMapping("/mostcaloriesIngredent/{nameDish}")
    public ResponseEntity<IngredentDTO> mostCaloriesIngredientDish(@PathVariable String nameDish){
        return new ResponseEntity<>(iDishService.getIngredentMostCalories(nameDish), HttpStatus.OK);
    }

}
