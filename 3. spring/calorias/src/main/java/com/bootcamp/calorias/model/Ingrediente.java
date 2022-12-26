package com.bootcamp.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ingrediente {
    private String name;
    private float calories;

    public Ingrediente() {}
}
