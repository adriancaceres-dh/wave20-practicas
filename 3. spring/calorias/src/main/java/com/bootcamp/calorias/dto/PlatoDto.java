package com.bootcamp.calorias.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PlatoDto {
    private String name;
    private List<IngredienteDto> ingredients;
}
