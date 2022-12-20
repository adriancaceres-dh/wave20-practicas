package com.bootcamp.clases;

import java.util.List;

public class Factura {
    private final Cliente cliente;
    private final List<Item> items;
    private final double total;

    public Factura(Cliente cliente, List<Item> items, double total) {
        this.cliente = cliente;
        this.items = items;
        this.total = items.stream().mapToDouble(Item::getCosto).sum();
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

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
