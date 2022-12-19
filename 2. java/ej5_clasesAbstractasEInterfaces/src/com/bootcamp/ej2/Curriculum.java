package com.bootcamp.ej2;

import java.util.List;

public class Curriculum implements Documento{

    private Persona persona;
    private List<String> habilidades;

    public Curriculum() {
    }

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum...");
    }
}
