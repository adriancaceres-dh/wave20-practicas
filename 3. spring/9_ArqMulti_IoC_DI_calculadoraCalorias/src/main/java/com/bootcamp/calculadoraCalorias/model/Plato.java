package com.bootcamp.calculadoraCalorias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class Plato {
    private String nombre;
    private Integer peso;
    private List<Ingrediente> listaIngredientes;
}
