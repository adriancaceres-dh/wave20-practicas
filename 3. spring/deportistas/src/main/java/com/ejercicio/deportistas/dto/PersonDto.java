package com.ejercicio.deportistas.dto;

import org.springframework.web.bind.annotation.GetMapping;

public class PersonDto {

    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public PersonDto(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
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

    @Override
    public String toString() {
        return "PersonDto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreDeporte='" + nombreDeporte + '\'' +
                '}';
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }
}
