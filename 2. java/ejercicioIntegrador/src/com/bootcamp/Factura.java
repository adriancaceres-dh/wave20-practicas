package com.bootcamp;

import java.util.List;

public class Factura {
    List<Item> items;
    double totalCompra;
    Cliente cliente;

    public Factura() {
    }

    public Factura(List<Item> items, double totalCompra, Cliente cliente) {
        this.items = items;
        this.totalCompra = totalCompra;
        this.cliente = cliente;
    }

}
