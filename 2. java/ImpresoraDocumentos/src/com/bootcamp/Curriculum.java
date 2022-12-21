package com.bootcamp;

import java.util.List;

public class Curriculum implements IImprimible{

    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimirse() {
        System.out.println("Curriculum: ");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Edad: " + persona.getEdad());
        System.out.println("Dni: " + persona.getDni());
        System.out.println("Habilidades: " + this.habilidades);
    }
}
