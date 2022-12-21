package com.bootcamp;

public class Nave {
    private String nombre;
    private int x;
    private int y;
    private int puntos;

    public Nave(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        puntos = 0;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void addPuntos() {
        puntos++;
    }

    public double obtenerDistanciaAlPunto(int x2, int y2) {
        return Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2));
    }

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", puntos=" + puntos +
                '}';
    }
}
