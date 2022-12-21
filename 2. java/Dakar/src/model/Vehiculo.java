package model;

public abstract class Vehiculo {
    protected double velocidad;
    protected double aceleracion;
    protected double anguloDeGiro;
    protected String patente;
    protected double peso;
    protected int ruedas;

    public String getPatente() {
        return patente;
    }
}
