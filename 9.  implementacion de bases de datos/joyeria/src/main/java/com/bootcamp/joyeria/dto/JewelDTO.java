package com.bootcamp.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JewelDTO {

    private Integer nroIdentificatorio;

    private String nombre;

    private String material;

    private Double peso;

    private String particularidad;

    private Boolean poseePiedra;

    private Boolean ventaONo;
}
