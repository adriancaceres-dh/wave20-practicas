package Ejercicio2.Clases;

import Ejercicio2.Interfaces.Imprimible;

public class Curriculum implements Imprimible {
    private Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Curriculum{ \n" +
                  persona.toString() +
                " \n }";
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
