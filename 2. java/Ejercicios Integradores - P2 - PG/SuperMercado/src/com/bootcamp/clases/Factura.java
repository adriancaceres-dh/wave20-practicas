package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    Cliente cliente;
    double totalCompra;
    List<Producto> listaProductos;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        listaProductos = new ArrayList<>();
        totalCompra = 0;
    }

    public Factura(Cliente cliente, List<Producto> listaProductos) {
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        totalCompra = 0;
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

    public double calcularTotalCompra(){
        double total = 0;
        for (Producto producto: listaProductos) {
            total += (producto.getCantComprada() * producto.getCostoUnitario());
        }
        setTotalCompra(total);
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", totalCompra=" + totalCompra +
                ", listaProductos=" + listaProductos +
                '}';
    }
}
