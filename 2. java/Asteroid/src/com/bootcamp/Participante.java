package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    private String nombre;
    private List<Nave> naves;

    public Participante(String nombre) {
        this.nombre = nombre;
        naves = new ArrayList<>();
    }

    public void addNave(Nave nave) {
        naves.add(nave);
    }

    public void mostrarNaves() {
        naves.forEach(nave -> System.out.println(nave.getNombre() + " - Puntos: " + nave.getPuntos()));
    }

    public void agregarUnPuntoATodasSusNaves() {
        naves.forEach(Nave::addPuntos);
    }


    public List<Nave> getNaves() {
        return naves;
    }
}
