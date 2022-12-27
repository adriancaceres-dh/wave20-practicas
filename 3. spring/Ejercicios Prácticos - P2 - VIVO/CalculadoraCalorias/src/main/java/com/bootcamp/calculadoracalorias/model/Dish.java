package com.bootcamp.calculadoracalorias.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Dish {

    String name;
    List<Food> ingredients;
    int total_calories;

    public int calcularTotalCalorias(){
        int total = ingredients.stream().mapToInt(i -> i.getCalories()).sum();
        total_calories = total;
        return total;
    }
}
