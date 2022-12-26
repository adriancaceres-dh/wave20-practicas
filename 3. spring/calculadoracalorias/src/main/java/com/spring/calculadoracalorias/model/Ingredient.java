package com.spring.calculadoracalorias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Ingredient {

    private String name;

    public Ingredient() {
    }

    private double calories;
}
