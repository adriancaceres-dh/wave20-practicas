package org.example;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Imprimible[] imprimibles = {new Curriculum(), new Informe(), new LibroPDF()};
    Arrays.stream(imprimibles)
        .forEach(documento -> Impresora.imprimir(documento));
  }
}