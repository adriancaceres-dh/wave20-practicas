package com.bootcamp.documentos;

import com.bootcamp.personas.Persona;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements IImprimir{

    Persona persona;
    List<String> habilidades;

    public Curriculum(Persona persona) {
        this.persona = persona;
        this.habilidades = new ArrayList<>();
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
        System.out.println("---Curriculum---");
        System.out.println("persona: " + persona.getNombre());
        System.out.println("habilidades: " + habilidades);
    }
}
