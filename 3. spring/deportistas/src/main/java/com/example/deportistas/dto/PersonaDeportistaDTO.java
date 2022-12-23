package com.example.deportistas.dto;

public class PersonaDeportistaDTO {
    private String nombre;
    private String apellido;
    private String deportes; // Como String para que tenga sentido el DTO

    public PersonaDeportistaDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDeportes() {
        return deportes;
    }

    public void setDeportes(String deportes) {
        this.deportes = deportes;
    }
}
