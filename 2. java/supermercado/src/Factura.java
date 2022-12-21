import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
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

    public float total(){
        float total = 0;
        for (Item item: items) total+=item.getCantidad()* item.getCosto_unitario();
        return Math.round(total*100)/100f;
    }

}
