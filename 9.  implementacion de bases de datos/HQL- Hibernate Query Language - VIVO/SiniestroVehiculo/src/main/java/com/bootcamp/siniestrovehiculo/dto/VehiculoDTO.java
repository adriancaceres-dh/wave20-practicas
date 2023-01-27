package com.bootcamp.siniestrovehiculo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDTO {

    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer annoFabricacion;
    private Integer cantRuedas;
}
