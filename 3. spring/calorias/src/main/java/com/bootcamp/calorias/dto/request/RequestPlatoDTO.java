package com.bootcamp.calorias.dto.request;

import com.bootcamp.calorias.dto.IngredienteDTO;
import lombok.Data;

import java.util.List;

@Data
public class RequestPlatoDTO {
    private String nombre;
    private int pesoEnGramos;
    private List<String> ingredientes;
}
