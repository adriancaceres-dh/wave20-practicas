package com.bootcamp;

public class LibrosEnPdf implements IImpresora {
    private int cantidadDePaginas;
    private String nombreDelAutor;
    private String titulo;
    private String genero;

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getNombreDelAutor() {
        return nombreDelAutor;
    }

    public void setNombreDelAutor(String nombreDelAutor) {
        this.nombreDelAutor = nombreDelAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LibrosEnPdf(int cantidadDePaginas, String nombreDelAutor, String titulo, String genero) {
        this.cantidadDePaginas = cantidadDePaginas;
        this.nombreDelAutor = nombreDelAutor;
        this.titulo = titulo;
        this.genero = genero;


    }

    @Override
    public void imprimir() {
        System.out.println("Nombre del autor: " + nombreDelAutor + "\n"
        + "Cantidad de páginas: " + cantidadDePaginas + "\n"
        + "Titulo: " + titulo + "\n"
        + "Género: " + genero + "\n");
    }
}
