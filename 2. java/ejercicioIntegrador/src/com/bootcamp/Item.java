package com.bootcamp;

public class Item {
    double costoUnitario;
    String codigo;
    String nombre;
    int cantidadComprada;

    public Item() {
    }

    public Item(double costoUnitario, String codigo, String nombre, int cantidadComprada) {
        this.costoUnitario = costoUnitario;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
    }


}
