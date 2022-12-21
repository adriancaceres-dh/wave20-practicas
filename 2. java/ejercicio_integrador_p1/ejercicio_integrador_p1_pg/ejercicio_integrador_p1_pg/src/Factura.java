import java.util.ArrayList;
import java.util.List;

public class Factura {
    protected Client client;
    protected List<Item> items = new ArrayList<Item>();
    protected double precioTotal;

    public Factura(Client client, List<Item> items, double precioTotal) {
        this.client = client;
        this.items = items;
        this.precioTotal = precioTotal;
    }
}
