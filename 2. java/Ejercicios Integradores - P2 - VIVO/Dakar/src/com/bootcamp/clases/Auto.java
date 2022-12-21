package com.bootcamp.clases;

public class Auto extends Vehiculo{
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.ruedas = 4;
        this.peso = 1000;
    }
}
