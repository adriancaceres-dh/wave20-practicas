import java.util.List;

public class Factura {

    String dniCliente;
    List<int[]> itemsComprados;
    int total;

    public Factura() {
    }

    public Factura(String dniCliente, List<int[]> itemsComprados, int total) {
        this.dniCliente = dniCliente;
        this.itemsComprados = itemsComprados;
        this.total = total;
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public List<int[]> getItemsComprados() {
        return itemsComprados;
    }

    public void setItemsComprados(List<int[]> itemsComprados) {
        this.itemsComprados = itemsComprados;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "dniCliente='" + dniCliente + '\'' +
                ", itemsComprados=" + itemsComprados +
                ", total=" + total +
                '}';
    }
}
