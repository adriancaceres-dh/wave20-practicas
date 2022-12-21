package supermercado;

import repositorios.FactoryRepositorioClientes;
import repositorios.RepositorioClientes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    long id;
    private Cliente cliente;
    private LocalDateTime fechaRealizacion;
    private List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        verificarCliente(cliente);
        this.cliente = cliente;
        this.fechaRealizacion = LocalDateTime.now();
        this.items = items;
    }

    public Factura(Cliente cliente) {
        verificarCliente(cliente);
        this.cliente = cliente;
        this.fechaRealizacion = LocalDateTime.now();
        this.items = new ArrayList<>();
        cliente.addFactura(this);
    }

    private void verificarCliente(Cliente cliente) {
        RepositorioClientes repo = FactoryRepositorioClientes.get();
        if (!repo.contains(cliente))
            repo.add(cliente);
    }

    public double getTotal() {
        return items.stream().mapToDouble(Item::calcularCosto).sum();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addAllItems(List<Item> items) {
        this.items.addAll(items);
    }

    public boolean removeItemById(long id) {
        return items.removeIf(item -> item.getId() == id);
    }

    public boolean removeItemByCode(String codigo) {
        return items.removeIf(item -> item.getProducto().getCodigo().equals(codigo));
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente.getNombre() + " " + cliente.getApellido() +
                ", fechaRealizacion=" + fechaRealizacion +
                ", items=" + items +
                '}';
    }
}
