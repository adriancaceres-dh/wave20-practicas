package com.example.calc.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Plato {
    private List<Ingrediente> ingredientes;

    public Ingrediente ingredienteConMasCalorias(){
        //Ingrediente in =  database.stream().max(Comparator.comparing(v->v.getCalorias())).get();
        Ingrediente ingredienteAretornar = ingredientes.get(0);
        for (Ingrediente ingrediente: ingredientes)
            if(ingrediente.getCalories() > ingredienteAretornar.getCalories()) ingredienteAretornar = ingrediente;
        return ingredienteAretornar;
    }

    public int totalDeCalorias(){
        int caloriasTotales = 0;
        for (Ingrediente ingrediente: ingredientes) caloriasTotales+=ingrediente.getCalories();
        return caloriasTotales;
    }

}
