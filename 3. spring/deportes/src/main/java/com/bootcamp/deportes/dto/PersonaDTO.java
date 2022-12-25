package com.bootcamp.deportes.dto;

import java.io.Serializable;

public class PersonaDTO implements Serializable{
    public String nombre;
    public String apellido;
    public String deporte;

    public PersonaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }
}
