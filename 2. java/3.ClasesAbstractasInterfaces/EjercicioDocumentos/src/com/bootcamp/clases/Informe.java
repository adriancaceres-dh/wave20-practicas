package com.bootcamp.clases;

import com.bootcamp.interfaces.IImpresion;

public class Informe implements IImpresion {
    String texto,autor,revisor;
    int longitudTexto,cantidadPaginas;

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                ", longitudTexto=" + longitudTexto +
                ", cantidadPaginas=" + cantidadPaginas +
                '}';
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public int getLongitudTexto() {
        return longitudTexto;
    }

    public void setLongitudTexto(int longitudTexto) {
        this.longitudTexto = longitudTexto;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public Informe(String texto, String autor, String revisor, int longitudTexto, int cantidadPaginas) {
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
        this.longitudTexto = longitudTexto;
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }
}
