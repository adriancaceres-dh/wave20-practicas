import java.util.List;

public class Factura {


    private List<Item> items;
    private Cliente cliente;
    private double total;

    public Factura(List<Item> items, Cliente cliente, double total) {
        this.items = items;
        this.cliente = cliente;
        this.total = calcular();

    }

    private double calcular(){
        double total = 0;
        for(Item i : items){
            total += i.getPrecioUnitario()*i.getCantidad();
        }
        return total;
    }
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
                "items=" + items +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }
}
