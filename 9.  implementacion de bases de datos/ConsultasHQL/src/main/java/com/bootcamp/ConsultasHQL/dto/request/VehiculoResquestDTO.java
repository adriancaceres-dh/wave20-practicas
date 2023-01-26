package com.bootcamp.ConsultasHQL.dto.request;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class VehiculoResquestDTO {
    private String patente;
    private String marca;
    private String modelo;
    private Long anoDeFabricacion;
    private Integer cantidadDeRuedas;
}
