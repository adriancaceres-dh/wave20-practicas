package com.bootcamp;

public class NaveSimple extends NaveBase {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public NaveSimple(String nombre, double x, double y) {
        super(nombre);
        this.x = x;
        this.y = y;
    }

    @Override
    public double distancia(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    @Override
    public String toString() {
        return String.format("%-8s  x:%5.1f    y:%5.1f", nombre, x, y);
    }
}
