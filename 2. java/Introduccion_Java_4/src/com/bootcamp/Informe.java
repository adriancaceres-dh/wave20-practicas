package com.bootcamp;

public class Informe {
    String longitud;
    int cantidadDePaginas;
    String autor;
    String revisor;

    public Informe(String longitud, int cantidadDePaginas, String autor, String revisor) {
        this.longitud = longitud;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "longitud='" + longitud + '\'' +
                ", cantidadDePaginas=" + cantidadDePaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
