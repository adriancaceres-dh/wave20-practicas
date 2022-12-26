package com.bootcamp.calorias.model;

import lombok.Data;

import java.util.List;

@Data
public class Plato {
    private String nombre;
    private int pesoEnGramos;
    private List<Ingrediente> ingredientes;
}
