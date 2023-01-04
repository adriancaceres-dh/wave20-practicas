package supermercado.model;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        items.forEach(item -> total += (item.getPrecioUnitario() * item.getCantidad()));
    }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<Item> getItems() { return items; }

    public void setItems(List<Item> items) { this.items = items; }

    public double getTotal() { return total; }

    public void setTotal(double total) { this.total = total; }


    @Override
    public String toString() {
        return "Factura:" +
                "\n     " + cliente.toString() +
                "\n     items: " + items.toString() +
                "\n     total: " + total + '\n';
    }

}
