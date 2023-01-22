package com.deportistas.deportistas.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String deportePersona;
    private int nivelDeporte;
}
