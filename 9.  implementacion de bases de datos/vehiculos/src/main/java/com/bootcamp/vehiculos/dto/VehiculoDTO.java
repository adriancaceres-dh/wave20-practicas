package com.bootcamp.vehiculos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class VehiculoDTO {
    private Long id;

    private String patente;

    private String marca;

    private String modelo;

    private Short anioFabricacion;

    private Short cantRuedas;
}
