package com.bootcamp.contadorcalorias.model;

import lombok.Data;

import java.util.List;

@Data
public class Dish {
    String name;
    List<Ingredient> ingredients;
}
