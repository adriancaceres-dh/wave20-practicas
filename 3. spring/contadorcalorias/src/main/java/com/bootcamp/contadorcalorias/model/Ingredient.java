package com.bootcamp.contadorcalorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    String name;
    int calories;

}
