package com.mercadolibre;

public class Main {
  public static void main(String[] args) {
    SerieCuadraticaIntegers serie = new SerieCuadraticaIntegers(2);
    for (int i = 0; i < 5; i++) {
      System.out.println(serie.siguienteValor());
    }

    SeriePotenciaDeDos seriePotenciaDeDos = new SeriePotenciaDeDos(2);
    for (int i = 0; i < 5; i++) {
      System.out.println(seriePotenciaDeDos.siguienteValor());
    }
  }
}