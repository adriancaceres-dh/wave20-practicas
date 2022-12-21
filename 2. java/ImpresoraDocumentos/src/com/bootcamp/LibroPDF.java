package com.bootcamp;

import com.bootcamp.IImprimible;

public class LibroPDF implements IImprimible {

    private int cantidadPaginas;
    private String nombreAutor;
    private String titulo;
    private String genero;

    public LibroPDF(int cantidadPaginas, String nombreAutor, String titulo, String genero) {
        this.cantidadPaginas = cantidadPaginas;
        this.nombreAutor = nombreAutor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimirse() {
        System.out.println("Libro en PDF: ");
        System.out.println("Cantidad de paginas: " + this.cantidadPaginas);
        System.out.println("Autor: " + this.nombreAutor);
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Genero: " + this.genero);
    }
}
