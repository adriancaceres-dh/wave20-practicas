package com.bootcamp.clases;

import com.bootcamp.interfaces.IImprimible;

public class Informe implements IImprimible {

    String autor;
    String revisor;
    int cantidadPaginas;
    String textto;

    public Informe(String autor, String revisor, int cantidadPaginas, String textto) {
        this.autor = autor;
        this.revisor = revisor;
        this.cantidadPaginas = cantidadPaginas;
        this.textto = textto;
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

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getTextto() {
        return textto;
    }

    public void setTextto(String textto) {
        this.textto = textto;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimir Informe");
    }
}
