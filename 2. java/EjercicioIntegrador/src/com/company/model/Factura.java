package com.company.model;

import java.util.List;

public class Factura {

    private Cliente cli;
    private List<Item> listaItems;
    private double total;

    public Factura(List<Item> itemsFactura, Cliente cliente) {
        this.listaItems=itemsFactura;
        this.cli = cliente;
        total = calcularTotal(itemsFactura);
        System.out.println("Se emitio factura por: " + total);
    }

    private double calcularTotal(List<Item> itemsFactura) {
        return itemsFactura.stream().mapToDouble(i -> i.getCostoUnitario() * i.getCant()).sum();
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public Factura() {
    }
}
