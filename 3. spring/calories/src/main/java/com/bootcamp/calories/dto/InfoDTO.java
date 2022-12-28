package com.bootcamp.calories.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class InfoDTO implements Serializable {
    private String name;
    private double totalCalories;
    private List<IngredientDTO> ingredientDTOS;
    private String nameIngredient;


}
