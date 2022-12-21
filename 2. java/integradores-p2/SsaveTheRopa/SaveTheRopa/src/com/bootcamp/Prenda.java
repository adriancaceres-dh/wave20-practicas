package com.bootcamp;

public class Prenda {
    String marca;
    String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Marca='" + marca + ", Modelo='" + modelo;
    }
}
