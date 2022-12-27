package com.bootcamp.contadorcalorias.service;

import com.bootcamp.contadorcalorias.dto.DishDTOResponse;
import com.bootcamp.contadorcalorias.dto.IngredientDTO;
import com.bootcamp.contadorcalorias.model.Dish;

import java.util.List;

public interface IDishService {
    DishDTOResponse getDish(String name);
    Integer countCalories(Dish dish);
    List<IngredientDTO> listIngredients (Dish dish);

}
