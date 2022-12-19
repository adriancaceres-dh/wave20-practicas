package com.bootcamp;

import com.bootcamp.interfaces.Documento;

public class LibroPDF implements Documento {
    String titulo;
    String autor;
    int cantidadPaginas;
    String genero;

    public LibroPDF(String titulo, String autor, int cantidadPaginas, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", cantidadPaginas=" + cantidadPaginas +
                ", genero='" + genero + '\'' +
                '}';
    }


    @Override
    public String mostrarInfo() {
        return toString();
    }
}
