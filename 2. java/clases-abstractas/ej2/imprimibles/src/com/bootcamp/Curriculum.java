package com.bootcamp;

import java.util.Arrays;
import java.util.List;

public class Curriculum {

    Persona persona;
    List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum:" +
                "Persona='" + persona + '\'' +
                ", Habilidades=" + habilidades +
                '\n';
    }
}
