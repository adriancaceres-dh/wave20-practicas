package com.bootcamp;

import java.util.List;

public class Curriculum {

    private String atributosPersona;
    private List<String> habilidades;

    public Curriculum(String atributosPersona, List<String> habilidades) {
        this.atributosPersona = atributosPersona;
        this.habilidades = habilidades;
    }

    public String getAtributosPersona() {
        return atributosPersona;
    }

    public void setAtributosPersona(String atributosPersona) {
        this.atributosPersona = atributosPersona;
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
                "atributosPersona='" + atributosPersona + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }


}
