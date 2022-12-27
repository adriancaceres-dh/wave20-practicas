package com.bootcamp.calculadoracalorias.dto.response;

import com.bootcamp.calculadoracalorias.model.Food;
import lombok.Data;

import java.util.List;

@Data
public class DishDto {

    String name;
    List<FoodDto> ingredients;
    int total_calories;
}
