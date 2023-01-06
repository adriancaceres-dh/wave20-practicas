package com.bootcamp.model;

public class Auto extends Vehiculo {
    private static final int peso = 1000;
    private static final int ruedas = 4;

    public Auto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }
}
