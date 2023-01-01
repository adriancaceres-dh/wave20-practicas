package com.bootcamp.Deportistas.dto;

import java.util.List;

public class DeportistaDTO {
    String nombre;
    String apellido;
    List<String> deportes;

    public DeportistaDTO(String nombre, String apellido, List<String> deportes) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deportes = deportes;
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

    public List<String> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<String> deportes) {
        this.deportes = deportes;
    }
}
