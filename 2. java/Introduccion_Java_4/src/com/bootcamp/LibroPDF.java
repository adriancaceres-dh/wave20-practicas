package com.bootcamp;

public class LibroPDF {
    String titulo, autor, genero;
    int cantidadDePaginas;

    public LibroPDF(String titulo, String autor, String genero, int cantidadDePaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.cantidadDePaginas = cantidadDePaginas;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", cantidadDePaginas=" + cantidadDePaginas +
                '}';
    }
}
