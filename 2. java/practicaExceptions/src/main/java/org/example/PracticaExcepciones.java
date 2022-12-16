package org.example;

public class PracticaExcepciones {
  private int a = 0;
  private int b = 300;
  public int calcularCociente() {
    int res = 0;
    try {
      res = b/a;
    }
    catch (ArithmeticException exception) {
      throw new IllegalArgumentException("No se puede dividir por 0");
      //System.out.println("No se puede dividir por 0");
    }
    finally {
      System.out.println("El programa ha finalizado");
    }
    return res;
  }
}
