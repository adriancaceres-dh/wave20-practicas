package com.bootcamp.clases;

public class Moto extends Vehiculo{
    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.ruedas = 2;
        this.peso = 300;
    }
}
