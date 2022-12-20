package com.bootcamp;

public class Informes implements Impresion{
    int cantidadPaginas;
    String autor;
    String revisor;
    String texto;

    public Informes(int cantidadPaginas, String autor, String revisor, String texto) {
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "cantidadPaginas=" + cantidadPaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}
