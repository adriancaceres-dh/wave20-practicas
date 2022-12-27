package com.bootcamp.clases;

import com.bootcamp.interfaces.IAprender;

import java.util.ArrayList;
import java.util.List;

public class Estudiante extends Persona implements IAprender {

    private List<String> cursos;


    public Estudiante(String nombre, String dni, String tel) {
        super(nombre, dni, tel);
        this.cursos = new ArrayList<>();
    }

    public void agregarCurso(String curso) {
        cursos.add(curso);
    }

    public List<String> getCursos() {
        return cursos;
    }

    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }

    @Override
    public void aprendo() {
            System.out.println("Estoy estudiando: " + getCursos());
    }
}
