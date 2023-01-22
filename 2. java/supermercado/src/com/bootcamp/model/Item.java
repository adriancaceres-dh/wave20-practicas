package com.bootcamp.model;

public class Item {
    private Integer codigo;
    private  String nombre;
    private  double costo;
    private  int cantidad;

    public Item() {
    }

    public Item(Integer codigo, String nombre, double costo, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Item{" +
                " codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", costo=" + costo +
                ", cantidad =" + cantidad +
                '}';
    }
}
