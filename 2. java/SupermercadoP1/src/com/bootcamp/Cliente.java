package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private List<Factura> facturas;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.facturas = new ArrayList<>();
    }

    public void addFactura(Factura factura) {
        facturas.add(factura);
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", facturas=" + facturas.stream().map(Objects::toString).collect(Collectors.joining(", ")) +
                '}';
    }
}
