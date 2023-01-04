package com.bootcamp;

public class Informe {
    private int cantidadPaginas;
    private String autor;
    private String titulo;
    private String revisor;

    public Informe(int cantidadPaginas, String autor, String titulo, String revisor) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.titulo = titulo;
        this.revisor = revisor;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return String.format("Informe - %s - Escrito por %s - Revisado por %s - Total de %d paginas",
                titulo, autor, revisor, cantidadPaginas);
    }
}
