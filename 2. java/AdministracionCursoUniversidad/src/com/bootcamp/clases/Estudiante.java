package com.bootcamp.clases;

import com.bootcamp.interfaces.EstudiarInterface;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona implements EstudiarInterface {

    private List<String> materias;

    public Estudiante(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        materias = new ArrayList<>();
    }

    public void addMateria(String materia) {
        materias.add(materia);
    }

    @Override
    public void indicarResponsabilidades() {
        super.indicarResponsabilidades();
        System.out.println("Estoy cursando las siguientes materias");
        materias.forEach(System.out::println);
    }

    @Override
    public List<String> materiasCursando() {
        return materias;
    }
}
