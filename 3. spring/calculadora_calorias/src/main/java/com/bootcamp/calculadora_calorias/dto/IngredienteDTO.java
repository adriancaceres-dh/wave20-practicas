package com.bootcamp.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredienteDTO {
    private String nombre;
    private int calorias;
}
