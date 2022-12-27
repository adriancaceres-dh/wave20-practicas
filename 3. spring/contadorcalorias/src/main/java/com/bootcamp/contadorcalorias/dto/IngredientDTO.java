package com.bootcamp.contadorcalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientDTO {
    String name;
    int calories;
}
