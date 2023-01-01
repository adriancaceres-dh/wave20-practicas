package com.bootcamp.Deportistas.dto;

import com.bootcamp.Deportistas.model.Deporte;

import java.util.List;

public class PersonaDTO {
    String nombre;
    String apellido;
    int edad;
    List<Deporte> deportes;

    public PersonaDTO(String nombre, String apellido, int edad, List<Deporte> deportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deportes = deportes;
    }

    public PersonaDTO() {

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }
}
