package com.bootcamp;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum();
        LibroPDF libroPDF = new LibroPDF();
        Informe informe = new Informe();

        //Imprimir los documentos:
        Impresora.imprimir(curriculum);
        Impresora.imprimir(libroPDF);
        Impresora.imprimir(informe);
    }
}
