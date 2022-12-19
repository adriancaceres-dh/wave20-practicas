package com.bootcamp.clases;

import com.bootcamp.interfaces.IImprimible;

public class Informe extends Documento {
    private final String texto;
    private final int numeroPaginas;
    private final Persona autor;
    private final Persona revisor;

    public Informe(String texto, int numeroPaginas, Persona autor, Persona revisor) {
        this.texto = texto;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", autor=" + autor +
                ", revisor=" + revisor +
                '}';
    }
}
