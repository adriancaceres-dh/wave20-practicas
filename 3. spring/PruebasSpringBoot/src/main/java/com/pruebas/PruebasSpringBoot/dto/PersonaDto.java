package com.pruebas.PruebasSpringBoot.dto;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
public class PersonaDto {

    private String nombre;
    private String apellido;

    @ToString.Exclude
    private int edad;
    private String nombreDeporte;

}
