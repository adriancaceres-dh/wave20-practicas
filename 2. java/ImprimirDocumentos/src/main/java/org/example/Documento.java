package org.example;

public interface Documento {
  public void imprimir();
  public static void imprimir(Documento documento) {
    documento.imprimir();
  }
}
