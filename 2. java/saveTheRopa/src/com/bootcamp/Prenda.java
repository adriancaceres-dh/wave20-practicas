package com.bootcamp;

public class Prenda {
    private String marca, modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {return marca;}

    public void setMarca(String marca) {this.marca = marca;}

    public String getModelo() {return modelo;}

    public void setModelo(String modelo) {this.modelo = modelo;}

    @Override
    public String toString() {
        return "Prenda:" +
                "\n marca: " + marca +
                "\n modelo: " + modelo + '\n';
    }
}
