package com.bootcamp.dakar;

public abstract class Vehiculo {

    private double velocidad,aceleracion,anguloGiro,peso;
    private String patente;
    private int ruedas;

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloGiro() {
        return anguloGiro;
    }

    public void setAnguloGiro(double anguloGiro) {
        this.anguloGiro = anguloGiro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public double rapidez(){
        return (this.getVelocidad()*(this.getAceleracion()/2))/(this.getAnguloGiro()*(this.getPeso()-this.getRuedas()*100));
    }

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, double peso, String patente, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.peso = peso;
        this.patente = patente;
        this.ruedas = ruedas;
    }

}
