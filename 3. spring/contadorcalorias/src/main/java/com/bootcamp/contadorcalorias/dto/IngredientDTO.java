package com.bootcamp.contadorcalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class IngredientDTO {
    String name;
    int calories;
}
