package com.example.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredientes;
    private int caloriasPorGramo;

    public Plato(String nombre) {
        this.nombre = nombre;
        this.ingredientes = new ArrayList<>();
    }

    public void addIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
        calcularCaloriasPorGramo();
    }

    private void calcularCaloriasPorGramo() {
        caloriasPorGramo = ingredientes.stream()
                .mapToInt(Ingrediente::getCalorias)
                .sum();
    }
}
