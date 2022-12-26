package com.example.ejerciciocalorias.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PlatoDto {
    private String nombre;
    private int peso;
    private List<IngredienteDto> ingredientes;

}
