package com.bootcamp.calculadora_calorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;
}
