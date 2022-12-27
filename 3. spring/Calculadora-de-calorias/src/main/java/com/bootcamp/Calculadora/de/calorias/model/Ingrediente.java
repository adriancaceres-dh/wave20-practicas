package com.bootcamp.Calculadora.de.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Comparator;

@AllArgsConstructor
@Data
@Builder
public class Ingrediente {

    private String name;
    private String calories;

    public Ingrediente() {
    }

}
