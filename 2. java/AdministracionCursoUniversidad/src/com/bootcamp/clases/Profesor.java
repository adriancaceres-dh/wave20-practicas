package com.bootcamp.clases;

import com.bootcamp.interfaces.EnsenarInterface;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona implements EnsenarInterface {
    private List<String> cursos;

    public Profesor(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        cursos = new ArrayList<>();
    }

    public void addCurso(String curso) {
        cursos.add(curso);
    }

    @Override
    public void indicarResponsabilidades() {
        super.indicarResponsabilidades();
        System.out.println("Estoy enseñando las siguientes materias");
        cursos.forEach(System.out::println);
    }

    @Override
    public List<String> materiasEnseniadas() {
        return cursos;
    }
}
