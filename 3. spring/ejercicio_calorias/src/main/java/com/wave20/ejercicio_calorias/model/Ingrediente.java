package com.wave20.ejercicio_calorias.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ingrediente {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("calories")
    private int calorias;
}