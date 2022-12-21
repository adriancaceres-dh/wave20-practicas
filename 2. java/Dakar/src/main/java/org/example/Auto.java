package org.example;

public class Auto extends Vehiculo {

  private static final int PESO = 1000;
  private static final int RUEDAS = 4;
  public Auto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
    super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
  }
}
