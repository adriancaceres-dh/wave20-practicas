package com.bootcamp.contadorcalorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Dish {
    String name;
    List<Ingredient> ingredients;
}
