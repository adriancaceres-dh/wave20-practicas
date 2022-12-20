package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    Cliente cliente;
    List<Producto> listaProductos;
    double totalCompra;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        listaProductos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
