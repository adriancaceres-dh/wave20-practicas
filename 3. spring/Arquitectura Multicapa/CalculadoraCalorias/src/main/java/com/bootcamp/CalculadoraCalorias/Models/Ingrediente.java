package com.bootcamp.CalculadoraCalorias.Models;

import lombok.Builder;
import lombok.Data;

@Data
public class Ingrediente {
    private String name;
    private int calories;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, int calorias) {
        this.name = nombre;
        this.calories = calorias;
    }
}
