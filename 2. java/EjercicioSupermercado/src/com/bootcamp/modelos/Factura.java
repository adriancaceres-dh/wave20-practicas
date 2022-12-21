package com.bootcamp.modelos;

import java.util.ArrayList;
import java.util.List;

public class Factura implements CRUD<Item> {
    private Cliente cliente;
    private List<Item> itemsFactura;
    private double totalFactura;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        itemsFactura = new ArrayList<>();
    }

    public Factura() {
        itemsFactura = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Factura addItem( Item item){
        itemsFactura.add(item);
        return this;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void calcularTotal(){
        totalFactura = itemsFactura.stream().mapToDouble(m -> m.calcularCostoProductos())
                .sum();
    }

    @Override
    public boolean crear(Item elementoNuevo) {
        return false;
    }

    @Override
    public Item buscar(List<Item> listaOriginal, String elementoABuscar) {
        return null;
    }

    @Override
    public boolean remover(String elementoARemover) {
        return false;
    }

    @Override
    public boolean modificar(Item elementoAModificar) {
        return false;
    }
}
