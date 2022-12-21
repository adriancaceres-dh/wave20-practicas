package com.bootcamp.clases;

public class Producto {

    String codigo;
    String nombre;
    int cantComprada;
    double costoUnitario;

    public Producto(String codigo, String nombre, int cantComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantComprada = cantComprada;
        this.costoUnitario = costoUnitario;
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

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantComprada=" + cantComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
