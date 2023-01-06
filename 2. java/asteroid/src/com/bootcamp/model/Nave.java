package com.bootcamp.model;

public class Nave implements IDestructor {
    private String nombre;
    private int x;
    private int y;
    private int puntos;

    public Nave() {
    }

    public Nave(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Nave(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.puntos = 0;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public double destruir(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
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
