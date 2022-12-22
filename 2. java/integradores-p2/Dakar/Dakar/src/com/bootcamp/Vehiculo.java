package com.bootcamp;

public class Vehiculo {
    double velocidad;
    double aceleracion;
    double anguloDeGiro;
    String patente;
    int peso;
    int ruedas;

    public Vehiculo (double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.patente = patente;
    }

    public double potencial () {
        return velocidad * 0.5 * aceleracion / (anguloDeGiro * (peso - ruedas * 100));
    }
}
