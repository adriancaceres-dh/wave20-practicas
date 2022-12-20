package com.bootcamp.clases;

import com.bootcamp.interfaces.IImpresion;

public class LibroPDF implements IImpresion {
    int cantidadPaginas;
    String autor,titulo,género;

    public LibroPDF(int cantidadPaginas, String autor, String titulo, String género) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.género = género;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGénero() {
        return género;
    }

    @Override
    public String toString() {
        return "LibroPDF{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", género='" + género + '\'' +
                '}';
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
