package com.bootcamp.clases;

import com.bootcamp.interfaces.IImprimible;

public class LibroPDF extends Documento {
    private final int cantidadPaginas;
    private final Persona autor;
    private final String titulo;
    private final String genero;

    public LibroPDF(int cantidadPaginas, Persona autor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor=" + autor +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}
