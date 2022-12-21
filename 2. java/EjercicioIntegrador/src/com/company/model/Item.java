package com.company.model;

public class Item {
    private String nombre;
    private int cant;
    private double costoUnitario;

    public Item() {
    }

    public Item(String nombre, int cant, double costoUnitario) {
        this.nombre = nombre;
        this.cant = cant;
        this.costoUnitario = costoUnitario;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}
