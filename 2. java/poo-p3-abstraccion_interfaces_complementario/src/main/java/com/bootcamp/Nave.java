package com.bootcamp;

public interface Nave {
    String getNombre();
    int getPuntaje();
    void setPuntaje(int puntaje);
    double distancia(double x, double y);
    @Override
    String toString();
}
