package com.bootcamp.model;

import java.util.List;

public class Factura {
    private Integer id_factura;
    private Cliente cliente;
    private List<Item> items;
    private  double total;

    public Factura() {
    }

    public Factura(Integer id_factura, Cliente cliente, List<Item> items, double total) {
        this.id_factura = id_factura;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public Integer getId_factura() {
        return id_factura;
    }

    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                " id-factura=" + id_factura +
                " cliente=" + cliente.toString() +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
