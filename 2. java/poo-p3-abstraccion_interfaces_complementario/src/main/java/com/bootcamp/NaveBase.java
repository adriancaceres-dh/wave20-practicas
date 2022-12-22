package com.bootcamp;

public abstract class NaveBase implements Nave {
    protected String nombre;
    protected int puntaje;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getPuntaje() {
        return puntaje;
    }

    @Override
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public NaveBase(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    @Override
    public abstract double distancia(double x, double y);

    @Override
    public abstract String toString();
}
