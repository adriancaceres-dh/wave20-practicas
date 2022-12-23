package com.bootcamp.covid.dto;

import com.bootcamp.covid.model.Sintoma;

import java.io.Serializable;
import java.util.Set;

public class PersonaRiesgoDTO implements Serializable {
    private long id;
    private String nombreCompleto;
    private int edad;
    private Set<Sintoma> sintomasRiesgo;

    public PersonaRiesgoDTO() {
    }

    public PersonaRiesgoDTO(long id, String nombreCompleto, int edad, Set<Sintoma> sintomasRiesgo) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.sintomasRiesgo = sintomasRiesgo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Set<Sintoma> getSintomasRiesgo() {
        return sintomasRiesgo;
    }

    public void setSintomasRiesgo(Set<Sintoma> sintomasRiesgo) {
        this.sintomasRiesgo = sintomasRiesgo;
    }
}
