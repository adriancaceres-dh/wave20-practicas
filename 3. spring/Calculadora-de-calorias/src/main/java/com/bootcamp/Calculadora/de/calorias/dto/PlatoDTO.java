package com.bootcamp.Calculadora.de.calorias.dto;

import com.bootcamp.Calculadora.de.calorias.model.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class PlatoDTO {

    private int cantidadTotalCalorias;
    private List<Ingrediente> ingredientes;
    private Ingrediente conMasCalorias;

    public PlatoDTO() {
    }
}
