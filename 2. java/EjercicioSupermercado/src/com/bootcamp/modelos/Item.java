package com.bootcamp.modelos;

public class Item {
    //código, nombre, cantidad comprada y costo unitario
    private int codigo;
    private String nombre;
    private int cantidadComprada;
    private double costoUnitorio;

    public Item() {
    }

    public Item(int codigo, String nombre, int cantidadComprada, double costoUnitorio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitorio = costoUnitorio;
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

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public double getCostoUnitorio() {
        return costoUnitorio;
    }

    public void setCostoUnitorio(double costoUnitorio) {
        this.costoUnitorio = costoUnitorio;
    }

    public double calcularCostoProductos(){
        return cantidadComprada * costoUnitorio;
    }
}
