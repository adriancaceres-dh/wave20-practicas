package com.spring.calculadoracalorias.service;

import com.spring.calculadoracalorias.dto.IngredentDTO;

public interface IDishService {
    double getCaloriesDish(String name);
    String getIngredentsCaloriesDish(String nameDish);
    IngredentDTO getIngredentMostCalories(String nameDish);
}
