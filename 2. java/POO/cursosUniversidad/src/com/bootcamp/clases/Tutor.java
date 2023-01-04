package com.bootcamp.clases;

import com.bootcamp.interfaces.IEnseniar;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends Estudiante implements IEnseniar {

    private List<String> cursosAEnseniar;

    public Tutor(String nombre, String dni, String tel) {
        super(nombre, dni, tel);
        this.cursosAEnseniar = new ArrayList<>();
    }

    public void cursosAEnseniar(String curso) {
        this.cursosAEnseniar.add(curso);
    }
    public List<String> getCursosAEnseniar() {
        return cursosAEnseniar;
    }

    public void setCursosAEnseniar(List<String> cursosAEnseniar) {
        this.cursosAEnseniar = cursosAEnseniar;
    }

    @Override
    public void ensenio() {
            System.out.println("A demás de estudiar" + getCursos() + "enseño: " + getCursosAEnseniar());
    }
}
