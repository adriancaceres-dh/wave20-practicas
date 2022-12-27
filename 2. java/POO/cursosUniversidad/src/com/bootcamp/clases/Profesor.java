package com.bootcamp.clases;

import com.bootcamp.interfaces.IEnseniar;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona implements IEnseniar {

    private List<String> cursosAEnseniar;

    public Profesor(String nombre, String dni, String tel) {
        super(nombre, dni, tel);
        this.cursosAEnseniar = new ArrayList<>();
    }

    public void agregarCursoAEnseniar(String curso){
        cursosAEnseniar.add(curso);
    }

    public List<String> getCursosAEnseniar() {
        return cursosAEnseniar;
    }

    public void setCursosAEnseniar(List<String> cursosAEnseniar) {
        this.cursosAEnseniar = cursosAEnseniar;
    }

    @Override
    public void ensenio() {
            System.out.println("Enseño: " + getCursosAEnseniar());
    }
}
