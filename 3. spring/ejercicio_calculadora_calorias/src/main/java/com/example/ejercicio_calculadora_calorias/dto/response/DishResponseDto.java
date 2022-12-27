package com.example.ejercicio_calculadora_calorias.dto.response;

import com.example.ejercicio_calculadora_calorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class DishResponseDto {

    private String name;
    private List<Ingredient> ingredients;
    private double totalDeCalorias;
    private Ingredient mostCaloricIngredient;
}
