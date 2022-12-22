package com.supermercado_1;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Producto> productos;
    private Double totalCompra;

    public Factura(Cliente cliente, List<Producto> productos, Double totalCompra) {
        this.cliente = cliente;
        this.productos = productos;
        this.totalCompra = totalCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", productos=" + productos +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
