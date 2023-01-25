package com.bootcamp.LasPerlas.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class JoyaDTO {
    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean posee_piedra;

    private Boolean ventaONo;
}
