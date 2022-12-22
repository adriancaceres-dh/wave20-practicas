package com.imprenta;

public class LibroPDF implements Documento {
    private String nombre;
    private int cantidadDePaginas;
    private String autor;
    private String titulo;

    public LibroPDF(String nombre, int cantidadDePaginas, String autor, String titulo) {
        this.nombre = nombre;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.titulo = titulo;
    }

    public int getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(int cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }
}
