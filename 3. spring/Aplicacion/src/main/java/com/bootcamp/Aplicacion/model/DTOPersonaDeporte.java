package com.bootcamp.Aplicacion.model;

public class DTOPersonaDeporte {
    String nombre;
    String apellido;
    String deporte;
    int edad;

    public DTOPersonaDeporte(String nombre, String apellido, String deporte, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
        this.edad = edad;
    }
}
