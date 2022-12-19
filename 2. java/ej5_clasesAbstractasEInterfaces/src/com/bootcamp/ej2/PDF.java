package com.bootcamp.ej2;

public class PDF implements Documento{

    private int cantPaginas;
    private String autor;
    private String titulo;
    private String genero;

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo libro PDF...");
    }
}
