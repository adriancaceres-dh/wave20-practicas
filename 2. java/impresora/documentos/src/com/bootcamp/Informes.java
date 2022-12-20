package com.bootcamp;

public class Informes implements IDescripcion{

    private String texto;
    private int longitud;
    private String revisor;
    private String autor;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void mostrar() {
        System.out.println("Informe: "+texto+ " del autor: "+autor+" con: "+longitud+" revisado por: "+revisor);
    }
}
