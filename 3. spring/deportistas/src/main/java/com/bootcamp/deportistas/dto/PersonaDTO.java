package com.bootcamp.deportistas.dto;

public class PersonaDTO {

    private String nombre;
    private String apellido;
    private String nombreDeporteRealizado;

    public PersonaDTO(String nombre, String apellido, String nombreDeporteRealizado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporteRealizado = nombreDeporteRealizado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreDeporteRealizado() {
        return nombreDeporteRealizado;
    }
}

