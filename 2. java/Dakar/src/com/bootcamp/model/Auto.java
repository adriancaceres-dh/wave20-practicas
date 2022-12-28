package com.bootcamp.model;

public class Auto extends Vehiculo {
    private static final Double PESO_AUTO = 1000.0;
    private static final Integer RUEDAS = 4;
    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_AUTO, RUEDAS);
    }

    @Override
    public String toString() {
        return "Auto{ " + super.toString() + " }";
    }
}
