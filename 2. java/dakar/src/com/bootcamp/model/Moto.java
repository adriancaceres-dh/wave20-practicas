package com.bootcamp.model;

public class Moto extends Vehiculo {
    private static final int peso = 300;
    private static final int ruedas = 2;

    public Moto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }
}
