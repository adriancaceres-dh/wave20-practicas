package com.example.ejercicio_calculadora_calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Dish {

    private String name;
    private List<Ingredient> ingredients;
    private double caloriesPer100Gramos;



}
