package com.bootcamp.model;

import java.util.List;

public class Flota implements IDestructor {
    private String nombre;
    private List<Nave> naves;
    private int puntos;

    public Flota(String nombre, List<Nave> naves) {
        this.nombre = nombre;
        this.naves = naves;
        this.puntos = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean addNave(Nave nave) {
        return naves.add(nave);
    }

    public Nave removeNave(int index) {
        return naves.remove(index);
    }

    public List<Nave> getNaves() {
        return naves;
    }

    public void setNaves(List<Nave> naves) {
        this.naves = naves;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public double destruir(int x, int y) {
        return naves.stream().mapToDouble(nave -> nave.destruir(x, y)).sum() / naves.size();
    }

    @Override
    public void addPunto() {
        puntos++;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getPuntos() {
        return puntos;
    }
}
