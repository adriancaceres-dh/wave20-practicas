package com.bootcamp.calories.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@ToString
public class IngredientDTO implements Serializable {
    private String name;
    private int calories;

}
