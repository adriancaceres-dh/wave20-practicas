package com.example.deportistas.dtos;

import java.io.Serializable;

public class PersonaDeporteDTO implements Serializable {
    private final String nombre;
    private final String apellido;
    private final String nivelDeporte;

    public PersonaDeporteDTO(String nombre, String apellido, String nivelDeporte) {
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
