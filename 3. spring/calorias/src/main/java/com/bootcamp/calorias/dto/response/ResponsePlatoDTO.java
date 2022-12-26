package com.bootcamp.calorias.dto.response;

import com.bootcamp.calorias.dto.IngredienteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponsePlatoDTO {
    private String nombre;
    private int pesoEnGramos;
    private int calorias;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO ingredienteConMasCalorias;
}
