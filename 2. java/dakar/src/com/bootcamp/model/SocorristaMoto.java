package com.bootcamp.model;

public class SocorristaMoto extends Vehiculo {

    public SocorristaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente, double peso, int ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo moto " + unaMoto.getPatente());
    }
}
