package com.bootcamp.prueba.service;

import com.bootcamp.prueba.Dto.CalorieDataDto;
import com.bootcamp.prueba.model.Ingredient;
import com.bootcamp.prueba.repository.CalorieDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalorieDataService {
    @Autowired
    private CalorieDataRepository calorieDataRepository;

    public CalorieDataDto getCalorieDataByName(String foodName, String weight) {
        List<Ingredient> dishIngredients = calorieDataRepository.getDishByName(foodName).getIngredientList();
        double calorieCount = 0;
        Ingredient highestCaloriesIngredient = dishIngredients.get(0);
        for (Ingredient ingrediente : dishIngredients) {
            calorieCount += (ingrediente.getCalories() / 100d) * Integer.parseInt(weight);
            if (ingrediente.getCalories() > highestCaloriesIngredient.getCalories()) {
                highestCaloriesIngredient = ingrediente;
            }
        }

        return CalorieDataDto.builder()
                .highestCalorieIngredient(highestCaloriesIngredient)
                .totalCalories(calorieCount)
                .ingredientList(dishIngredients)
                .build();

    }
}
