package com.mercadolibre;

import java.util.ArrayList;
import java.util.List;

public class Factura {
  private Cliente cliente;
  private List<Items> items;
  private double totalCompra;

  public Factura(Cliente cliente, List<Items> items, double totalCompra) {
    this.cliente = cliente;
    this.items = items;
    this.totalCompra = totalCompra;
  }

  public Factura(Cliente cliente) {
    this.cliente = cliente;
    this.totalCompra = 0;
    this.items = new ArrayList<>();
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<Items> getItems() {
    return items;
  }

  public void setItems(List<Items> items) {
    this.items = items;
  }

  public double getTotalCompra() {
    return totalCompra;
  }

  public void setTotalCompra(double totalCompra) {
    this.totalCompra = totalCompra;
  }

  public void agregarItem(Items item) {
    this.items.add(item);
    this.totalCompra += item.getPrecio();
  }
}
