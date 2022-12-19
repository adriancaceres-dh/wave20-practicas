package com.bootcamp.clases;

import com.bootcamp.interfaces.IImprimible;

import java.util.List;

public class Curriculum extends Documento {
    private final Persona persona;
    private final List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }
}
