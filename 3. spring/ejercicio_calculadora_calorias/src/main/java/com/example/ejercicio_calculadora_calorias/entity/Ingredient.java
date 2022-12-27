package com.example.ejercicio_calculadora_calorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {

    private String name;
    private String calories;

    public Ingredient() {
    }
}
