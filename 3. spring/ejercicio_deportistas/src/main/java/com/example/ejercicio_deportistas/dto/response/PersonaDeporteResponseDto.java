package com.example.ejercicio_deportistas.dto.response;

import java.util.ArrayList;
import java.util.List;

public class PersonaDeporteResponseDto {

    private String nombre;
    private String apellido;

    private List<String> deportes;

    public PersonaDeporteResponseDto(){}

    public PersonaDeporteResponseDto(String nombre, String apellido) {
        deportes = new ArrayList<>();
        this.nombre = nombre;
        this.apellido = apellido;
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
