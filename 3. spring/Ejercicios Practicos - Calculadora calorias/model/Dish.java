package com.bootcamp.prueba.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Dish {
    private String name;
    private List<Ingredient> ingredientList;
}
