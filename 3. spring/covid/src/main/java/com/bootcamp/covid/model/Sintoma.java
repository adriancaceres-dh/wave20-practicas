package com.bootcamp.covid.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Sintoma {
    private String codigo;
    private String nombre;
    private NivelDeGravedad nivelDeGravedad;
}
