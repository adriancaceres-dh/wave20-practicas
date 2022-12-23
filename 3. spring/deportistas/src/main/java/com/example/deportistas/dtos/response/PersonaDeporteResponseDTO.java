package com.example.deportistas.dtos.response;

import java.io.Serializable;

public class PersonaDeporteResponseDTO implements Serializable {
    private final String nombre;
    private final String apellido;
    private final String nivelDeporte;

    public PersonaDeporteResponseDTO(String nombre, String apellido, String nivelDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nivelDeporte = nivelDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNivelDeporte() {
        return nivelDeporte;
    }
}
