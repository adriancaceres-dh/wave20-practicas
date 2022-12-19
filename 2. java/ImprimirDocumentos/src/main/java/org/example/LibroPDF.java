package org.example;

public class LibroPDF implements Documento {
  @Override
  public void imprimir() {
    System.out.println("Libro PDF impreso");
  }
}

