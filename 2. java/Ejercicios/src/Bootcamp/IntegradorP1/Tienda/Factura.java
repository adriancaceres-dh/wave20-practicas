package Bootcamp.IntegradorP1.Tienda;

import java.util.List;

public class Factura {
    private Integer codigo;
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Integer codigo, Cliente cliente, List<Item> items, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
