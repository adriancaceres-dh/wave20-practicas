package com.bootcamp.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredienteDTO {

    private String nombre;
    private int calorias;

}
