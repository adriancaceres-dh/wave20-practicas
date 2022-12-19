package org.example;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Documento[] documentos = {new Curriculum(), new Informe(), new LibroPDF()};
    Arrays.stream(documentos)
        .forEach(documento -> Impresora.imprimir(documento));
  }
}