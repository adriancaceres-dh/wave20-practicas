package com.bootcamp;

import com.bootcamp.interfaces.Documento;
import java.util.List;

public class Curriculum implements Documento {

    String nombre;
    String celular;
    String experiencia;
    String email;
    List<String> habilidades;


    public Curriculum(String nombre, String celular, String experiencia, String email, List<String> habilidades) {
        this.nombre = nombre;
        this.celular = celular;
        this.experiencia = experiencia;
        this.email = email;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                ", experiencia='" + experiencia + '\'' +
                ", email='" + email + '\'' +
                ", habilidades=" + habilidades.toString() +
                '}';
    }

    @Override
    public String mostrarInfo() {
        return toString();
    }
}
