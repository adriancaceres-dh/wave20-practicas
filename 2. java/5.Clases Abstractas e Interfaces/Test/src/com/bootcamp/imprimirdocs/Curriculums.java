package com.bootcamp.imprimirdocs;

public class Curriculums {
    Persona persona;

    public Curriculums(Persona persona) {
        this.persona = persona;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    @Override
    public String toString() {
        return "Curriculums{" +
                "persona=" + persona +
                '}';
    }
}
