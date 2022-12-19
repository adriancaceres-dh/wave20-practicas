package org.example;

public interface Imprimible {
  public void imprimir();
  public static void imprimir(Imprimible imprimible) {
    imprimible.imprimir();
  }
}
