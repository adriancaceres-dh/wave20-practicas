package com.bootcamp.prueba.service;

import com.bootcamp.prueba.Dto.CalorieDataDto;
import com.bootcamp.prueba.model.Dish;
import com.bootcamp.prueba.model.Ingredient;
import com.bootcamp.prueba.repository.CalorieDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalorieDataService {
    @Autowired
    private CalorieDataRepository calorieDataRepository;

    public CalorieDataDto getCalorieDataByName(String foodName, String weight) {
        Dish dish = calorieDataRepository.getDishByName(foodName);
        int calorieCount = 0;
        Ingredient highestCaloriesIngredient = null;
        for (var ingrediente : dish.getIngredientList()) {
            calorieDataDto.setTotalCalories();
        }

        CalorieDataDto calorieDataDto = CalorieDataDto.builder().build();
        return null;

    }
}
