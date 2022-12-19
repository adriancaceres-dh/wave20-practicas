package com.bootcamp.ej2;

public class Informe implements Documento{

    int cantPaginas;
    String autor;
    String revisor;

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe...");
    }
}
