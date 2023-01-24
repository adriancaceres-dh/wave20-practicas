package com.bootcamp.joyerialasperlas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JoyaRequestDTO {
    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean posee_piedra;
}
