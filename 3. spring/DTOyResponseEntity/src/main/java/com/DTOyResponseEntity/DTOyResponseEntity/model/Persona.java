package com.DTOyResponseEntity.DTOyResponseEntity.model;

import lombok.AllArgsConstructor;
import lombok.Data;


public class Persona {
    String nombre;
    String apellido;
    Integer edad;
    Deporte deporte;

    public Persona(String nombre, String apellido, Integer edad, Deporte deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public Deporte getDeporte() {
        return deporte;
    }
}
