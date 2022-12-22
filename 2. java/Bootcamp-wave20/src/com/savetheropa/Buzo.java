package com.savetheropa;

public class Buzo extends Prenda {

    public Buzo(String marca, String modelo, String nombre) {
        super(marca, modelo, nombre);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-10s", marca, modelo);
    }
}
