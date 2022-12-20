package com.bootcamp.clases;

import com.bootcamp.interfaces.IImprimible;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements IImprimible {

    Persona persona;
    List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Curriculum(Persona persona) {
        this.persona = persona;
        habilidades = new ArrayList<>();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir Curriculum");
    }
}
