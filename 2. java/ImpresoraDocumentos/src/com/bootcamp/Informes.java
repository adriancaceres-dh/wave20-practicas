package com.bootcamp;

public class Informes implements IImprimible{

    private String texto;
    private int cantidadPaginas;
    private String autor;
    private String revisor;

    public Informes(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimirse() {
        System.out.println("Informe: ");
        System.out.println("Cantidad de paginas: " + this.cantidadPaginas);
        System.out.println("Autor: " + this.autor);
        System.out.println("Revisor: " + this.revisor);
        System.out.println("Texto: " + this.texto);
    }
}
