package com.bootcamp;

public class Item {
    double costoUnitario;
    String codigo;
    String nombre;
    int cantidadComprada;


    public Item(double costoUnitario, String codigo, String nombre, int cantidadComprada) {
        this.costoUnitario = costoUnitario;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
    }

    @Override
    public String toString() {
        return "Item{" +
                "costoUnitario=" + costoUnitario +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                '}';
    }
}
