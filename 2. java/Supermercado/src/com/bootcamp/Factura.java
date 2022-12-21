package com.bootcamp;

import java.util.List;

public class Factura {
    String codigoFactura;
    private Cliente cliente;
    private List<Producto> items;
    double totalCompra;

    public Factura(Cliente cliente, List<Producto> items,String codigoFactura) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra=calcularTotalcompra();
        this.codigoFactura=codigoFactura;
    }

    private double calcularTotalcompra() {
        return items.stream().mapToDouble(item->(item.getCostoUnitario()* item.getCantidadComprada())).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getItems() {
        return items;
    }

    public void setItems(List<Producto> items) {
        this.items = items;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigoFactura='" + codigoFactura + '\'' +
                ", cliente=" + cliente +
                ", items=" + items +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
