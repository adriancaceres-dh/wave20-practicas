package com.bootcamp.EjercicioCovid19.models;

public class Sintoma {
    private String nombre;
    private Integer codigo, nivel_de_gravedad;

    public Sintoma(String nombre, Integer codigo, Integer nivel_de_gravedad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
    public Sintoma(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(Integer nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", nivel_de_gravedad=" + nivel_de_gravedad +
                '}';
    }
}
