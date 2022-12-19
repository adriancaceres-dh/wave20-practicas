package com.bootcamp;

import com.bootcamp.interfaces.Documento;

public class Informes implements Documento {

    String autor;
    String revisor;
    int cantidadDePaginas;
    String texto;

    public Informes(String autor, String revisor, int cantidadDePaginas, String texto) {
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadDePaginas = cantidadDePaginas;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Informes{" +
                "autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", cantidadDePaginas=" + cantidadDePaginas +
                ", texto='" + texto + '\'' +
                '}';
    }

    @Override
    public String mostrarInfo() {
        return toString();
    }
}
