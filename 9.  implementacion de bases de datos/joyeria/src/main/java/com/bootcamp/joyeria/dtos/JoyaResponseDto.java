package com.bootcamp.joyeria.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JoyaResponseDto {
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
