package org.example;

public class Moto extends Vehiculo {
  private static final int PESO = 300;
  private static final int RUEDAS = 2;
  public Moto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
    super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
  }
}

