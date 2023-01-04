package com.bootcamp.prueba.controller;

import com.bootcamp.prueba.Dto.CalorieDataDto;
import com.bootcamp.prueba.service.CalorieDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalorieCounterController {
    @Autowired
    private CalorieDataService calorieDataService;

    public CalorieCounterController(CalorieDataService calorieDataService) {
        this.calorieDataService = calorieDataService;
    }

    @GetMapping("calorieData/{foodName}/{weight}")
    public CalorieDataDto getCalorieDataByFood(@PathVariable String foodName,
                                               @PathVariable String weight) {
        return calorieDataService.getCalorieDataByName(foodName, weight);
    }

}
