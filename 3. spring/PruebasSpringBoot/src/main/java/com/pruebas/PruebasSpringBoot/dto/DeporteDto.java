package com.pruebas.PruebasSpringBoot.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeporteDto {
    private String nombre;
    private String nivel;

}
