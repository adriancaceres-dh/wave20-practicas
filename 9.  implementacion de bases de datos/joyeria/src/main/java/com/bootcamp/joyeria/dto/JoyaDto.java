package com.bootcamp.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoyaDto {
    private  Long nroIdentificatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean ventaONo;
}
