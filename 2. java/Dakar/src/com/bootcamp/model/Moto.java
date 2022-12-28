package com.bootcamp.model;

public class Moto extends Vehiculo{

    private static final Double PESO_MOTO = 300.0;
    private static final Integer RUEDAS = 2;

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_MOTO, RUEDAS);
    }

    @Override
    public String toString() {
        return "Moto{ " + super.toString() + " }";
    }
}
