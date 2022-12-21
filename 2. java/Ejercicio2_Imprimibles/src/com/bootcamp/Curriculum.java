package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible {
    private String persona;
    private List<String> atributos;

    public Curriculum(String persona) {
        this.persona = persona;
        atributos = new ArrayList<>();
    }

    public Curriculum() {
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public List<String> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<String> atributos) {
        this.atributos = atributos;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Curriculum impreso");
    }
}
