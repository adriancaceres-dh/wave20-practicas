package com.bootcamp;

public class Informes implements IImpresora{
    private int longitudTexto;
    private int cantidadDePaginas;
    private String autor;
    private String revisor;

    public int getLongitudTexto() {
        return longitudTexto;
    }

    public void setLongitudTexto(int longitudTexto) {
        this.longitudTexto = longitudTexto;
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

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public Informes(int longitudTexto, int cantidadDePaginas, String autor, String revisor) {
        this.longitudTexto = longitudTexto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public void imprimir() {
        System.out.println("Longitud de texto: " + longitudTexto + "\n"
                + "Cantidad de páginas: " + cantidadDePaginas + "\n"
                + "Autor: " + autor + "\n"
                + "Revisor: " + revisor + "\n");
    }
}
