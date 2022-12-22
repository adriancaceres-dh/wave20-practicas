package com.bootcamp;

public class Prenda {

    String marca;
    String modelo;

    public Prenda() {

    }

    public Prenda(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
