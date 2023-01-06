package com.bootcamp.model;

public class SocorristaAuto extends Vehiculo {

    public SocorristaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Auto unAuto) {
        System.out.println("Socorriendo auto " + unAuto.getPatente());
    }
}
