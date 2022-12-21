package com.mercadolibre.model;

import java.util.ArrayList;
import java.util.List;

public class Factura {
  private Cliente cliente;
  private List<Item> items;
  private double totalCompra;

  public Factura(Cliente cliente, List<Item> items) {
    this.cliente = cliente;
    this.items = items;
    this.totalCompra = calcularTotalCompra();
  }

  public Factura(Cliente cliente) {
    this.cliente = cliente;
    this.totalCompra = 0;
    this.items = new ArrayList<>();
  }


  private int calcularTotalCompra() {
    int total = 0;
    for (Item item : items) {
      total += item.getPrecio();
    }
    return total;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
    this.totalCompra = calcularTotalCompra();
  }

  public double getTotalCompra() {
    return totalCompra;
  }

  public void agregarItem(Item item) {
    this.items.add(item);
    this.totalCompra += item.getPrecio();
  }

  @Override
  public String toString() {
    return "Factura{" +
            "cliente=" + cliente +
            ", items=" + items +
            ", totalCompra=" + totalCompra +
            '}';
  }
}
