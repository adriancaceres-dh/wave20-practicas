package com.savetheropa;

public abstract class Prenda {
    protected String marca;
    protected String modelo;

    protected String nombre;

    public Prenda(String marca, String modelo, String nombre) {
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
    }
}