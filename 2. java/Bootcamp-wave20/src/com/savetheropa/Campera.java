package com.savetheropa;

public class Campera extends Prenda {

    public Campera(String marca, String modelo, String nombre) {
        super(marca, modelo, nombre);
    }

    @Override
        public String toString() {
            return String.format("%-10s %-10s", marca, modelo);
        }



}

