package supermercado;

import java.time.LocalDateTime;
import java.util.List;

public class Factura {
    long id;
    private Cliente cliente;
    private LocalDateTime fechaRealizacion;
    private List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.fechaRealizacion = LocalDateTime.now();
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
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
                "cliente=" + cliente +
                ", fechaRealizacion=" + fechaRealizacion +
                ", items=" + items +
                '}';
    }
}
