package com.bootcamp.calculadora_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlatoDTO {
    private int calorias;
    private List<IngredienteDTO> ingredientes;
    private String ingredienteMasCalorias;
}
