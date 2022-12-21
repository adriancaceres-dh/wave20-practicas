package com.bootcamp.clases;

import com.bootcamp.interfaces.IImpresora;

public class LibroPdf implements IImpresora {
    private String título;
    private String genero;
    private String nombreAutor;
    private int cantidadPaginas;

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo un Libro PDF");
    }

    @Override
    public String toString() {
        return "LibroPdf{" +
                "título='" + título + '\'' +
                ", genero='" + genero + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }
}
