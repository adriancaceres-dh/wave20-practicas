package org.example;

public abstract class Vehiculo {
  private int velocidad;
  private int aceleracion;
  private int anguloDeGiro;
  private String patente;
  private int peso;
  private int numRuedas;

  public Vehiculo(int velocidad, int aceleracion, int anguloDeGiro, String patente, int peso, int numRuedas) {
    this.velocidad = velocidad;
    this.aceleracion = aceleracion;
    this.anguloDeGiro = anguloDeGiro;
    this.patente = patente;
    this.peso = peso;
    this.numRuedas = numRuedas;
  }

  public int getVelocidad() {
    return velocidad;
  }

  public int getAceleracion() {
    return aceleracion;
  }

  public int getAnguloDeGiro() {
    return anguloDeGiro;
  }

  public String getPatente() {
    return patente;
  }

  public int getPeso() {
    return peso;
  }

  public int getNumRuedas() {
    return numRuedas;
  }
}
