package com.bootcamp.calculadoraCalorias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Ingrediente {
    private String name;
    private Integer calories;
    private Integer peso;
    public Ingrediente() {
    }

}
