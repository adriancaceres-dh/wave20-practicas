package com.bootcamp.Calculadora.de.calorias.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
@AllArgsConstructor
@Data
@Builder
public class Plato {

    private String nombrePlato;

    List<Ingrediente> ingredientes;

    public Plato() {
    }

    public Ingrediente mayorCalorias(){

        Ingrediente i =   this.getIngredientes().stream().max(Comparator.comparing(v->v.getCalories()))
                .orElseThrow(NullPointerException::new);
        return i;
    }

    public int cantidadTotalCalorias(String peso){

        int calorias =  this.getIngredientes().stream()
                .mapToInt(x->Integer.parseInt(x.getCalories()))
                .sum();

        int cantidadTotal = (calorias*Integer.parseInt(peso))/100;
        return cantidadTotal;
    }
}
