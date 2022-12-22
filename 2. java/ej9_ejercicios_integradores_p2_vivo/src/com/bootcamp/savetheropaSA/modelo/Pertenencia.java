package com.bootcamp.savetheropaSA.modelo;

public abstract class Pertenencia {

    private String marca, modelo;

    public Pertenencia(String marca, String modelo){
        this.modelo=modelo;
        this.marca=marca;
    }

    @Override
    public String toString() {
        return "Pertenencia{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
