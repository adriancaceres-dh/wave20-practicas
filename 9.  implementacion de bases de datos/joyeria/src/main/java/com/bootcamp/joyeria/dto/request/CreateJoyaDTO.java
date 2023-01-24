package com.bootcamp.joyeria.dto.request;

import lombok.Getter;

@Getter
public class CreateJoyaDTO {

    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
