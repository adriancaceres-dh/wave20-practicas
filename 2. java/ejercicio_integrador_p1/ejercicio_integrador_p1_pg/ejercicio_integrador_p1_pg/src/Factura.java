import java.util.ArrayList;
import java.util.List;

public class Factura {
    protected Client client;
    protected List<Item> items = new ArrayList<Item>();
    protected double precioTotal;

    public Factura(Client client, List<Item> items) {
        this.client = client;
        this.items = items;
        this.precioTotal = Logic.calcularTotal(items);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "client=" + client +
                ", items=" + items +
                ", precioTotal=" + precioTotal +
                '}';
    }

    public Client getClient() {
        return client;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }
}
