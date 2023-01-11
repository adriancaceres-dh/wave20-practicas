package com.bootcamp;

import java.util.List;

public class Localizador {
    private List<Item> items;
    private Cliente cliente;
    private double total;

    public Localizador(List<Item> items, Cliente cliente, double total) {
        this.items = items;
        this.cliente = cliente;
        this.total = total;
    }

    public Localizador() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void calcularTotal(){
        this.total = items.stream().mapToDouble(x->x.getPrecio()).sum();
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "items=" + items +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }

    public void calcularTotalDescuento(int descuentos) {
        this.total = items.stream().mapToDouble(x->x.getPrecio()).sum() ;
        this.total = this.total - this.total * (descuentos/100);
        System.out.println("Total : $"+total);
    }
}
