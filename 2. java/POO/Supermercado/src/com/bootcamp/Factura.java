package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    protected Cliente cliente;
    protected List<Item> items;
    protected double totalDeCompra;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalDeCompra() {
        return totalDeCompra;
    }

    public void setTotalDeCompra(double totalDeCompra) {
        this.totalDeCompra = totalDeCompra;
    }
}
