package com.bootcamp.clases;

import com.bootcamp.interfaces.EnsenarInterface;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Estudiante implements EnsenarInterface {

    private List<String> materiasEnseniadas;

    public Tutor(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        materiasEnseniadas = new ArrayList<>();
    }

    public void addMateriaAEnseniar(String materia) {
        materiasEnseniadas.add(materia);
    }

    @Override
    public void indicarResponsabilidades() {
        super.indicarResponsabilidades();
        System.out.println("Ademas, colaboro enseñando clases de:");
        materiasEnseniadas.forEach(System.out::println);
    }

    @Override
    public List<String> materiasEnseniadas() {
        return materiasEnseniadas;
    }
}
