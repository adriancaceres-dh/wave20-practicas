package com.bootcamp.model;

public class Item {
    private Long codigo;
    private String nombre;
    private Integer cantidad;
    private Double costoUnidad;

    public Item() {}

    public Item(Long codigo, String nombre, Integer cantidad, Double costoUnidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnidad = costoUnidad;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoUnidad() {
        return costoUnidad;
    }

    public void setCostoUnidad(Double costoUnidad) {
        this.costoUnidad = costoUnidad;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costoUnidad=" + costoUnidad +
                '}';
    }
}
