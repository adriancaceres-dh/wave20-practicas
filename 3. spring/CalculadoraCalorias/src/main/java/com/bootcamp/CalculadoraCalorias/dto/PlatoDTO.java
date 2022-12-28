package com.bootcamp.CalculadoraCalorias.dto;

import com.bootcamp.CalculadoraCalorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDTO {
    private String nombre;
    private List<String> ingredientes;
    private Double peso;

}
