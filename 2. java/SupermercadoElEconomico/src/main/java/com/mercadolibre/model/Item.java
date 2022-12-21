package com.mercadolibre.model;

public class Item {
  private double precio;
  private String nombre;

  public Item(String nombre, double precio) {
    this.precio = precio;
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  @Override
  public String toString() {
    return "Item{" +
            "precio=" + precio +
            ", nombre='" + nombre + '\'' +
            '}';
  }
}
