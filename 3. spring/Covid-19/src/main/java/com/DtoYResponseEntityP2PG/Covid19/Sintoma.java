package com.DtoYResponseEntityP2PG.Covid19;

import java.security.PublicKey;
import java.util.List;

public class Sintoma
{
    //Codigo, nombre, nivel de gravedad.
    int codigo;
    String nombre;
    int nivelDeGravedad;

    public Sintoma(){};
    public Sintoma(int codigo, String nombre, int nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", nivelDeGravedad=" + nivelDeGravedad +
                '}';
    }

    public int getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public void setNivelDeGravedad(int nivelDeGravedad) {
        this.nivelDeGravedad = nivelDeGravedad;
    }
}
