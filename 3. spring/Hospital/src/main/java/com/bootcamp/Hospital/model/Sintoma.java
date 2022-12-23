package com.bootcamp.Hospital.model;

public class Sintoma {

    private String codigo;
    private String nombre;
    private float nivel_de_gravedad;

    public Sintoma(){

    }

    public Sintoma(String codigo, String nombre, float nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(float nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }
}
