package com.bootcamp.clases;

import java.util.List;

public class Factura {
    private final String codigo;
    private final Cliente cliente;
    private final List<Item> items;
    private final double total;

    public Factura(String codigo, Cliente cliente, List<Item> items) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.total = items.stream().mapToDouble(i -> i.getCantidad() * i.getCosto()).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
