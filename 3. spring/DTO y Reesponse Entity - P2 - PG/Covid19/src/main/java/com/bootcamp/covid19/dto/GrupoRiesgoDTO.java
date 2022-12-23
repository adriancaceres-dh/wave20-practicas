package com.bootcamp.covid19.dto;

import java.io.Serializable;
import java.util.List;

public class GrupoRiesgoDTO implements Serializable {

    String nombre;
    String apellido;
    List<String> sintomas;

    public GrupoRiesgoDTO(String nombre, String apellido, List<String> sintomas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sintomas = sintomas;
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

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }
}
