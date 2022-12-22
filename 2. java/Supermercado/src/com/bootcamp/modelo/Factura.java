package com.bootcamp.modelo;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> listaItem;
    private double costoTotal;

    public Factura() {
    }

    public Factura(Cliente cliente, List<Item> listaItem, double costoTotal) {
        this.cliente = cliente;
        this.listaItem = listaItem;
        this.costoTotal = costoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItem() {
        return listaItem;
    }

    public void setListaItem(List<Item> listaItem) {
        this.listaItem = listaItem;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaItem=" + listaItem +
                ", costoTotal=" + costoTotal +
                '}';
    }
}
