package com.bootcamp.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IngredienteDTO {
    private String nombre;
    private int calorias;
}
