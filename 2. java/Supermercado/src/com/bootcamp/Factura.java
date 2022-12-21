package com.bootcamp;

import java.util.List;

public class Factura {

    private Long codigo;
    private Cliente cliente;
    private List<Item> listaItems;
    private double total;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
        this.total = calcularTotal();
    }

    public Factura(Long codigo, Cliente cliente, List<Item> listaItems) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        double total = 0;
        for (Item i : listaItems) {
            total += i.getCant() * i.getCostoUnitario();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }
}
