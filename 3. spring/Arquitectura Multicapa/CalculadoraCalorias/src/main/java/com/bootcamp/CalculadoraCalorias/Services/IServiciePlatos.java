package com.bootcamp.CalculadoraCalorias.Services;

import com.bootcamp.CalculadoraCalorias.DTO.IngredienteDto;

public interface IServiciePlatos {

    public int devolverCaloriasDelPlato(String nombrePlato);

    String devolverCaloriasEIngredientesDelPlato(String nombrePlato);

    IngredienteDto ingredienteMayorCaloria(String nombrePlato);
}
