import java.util.List;

public class Factura {
    Cliente cliente;
    List<Item> listaDeProductos;
    double totalCompra;

    public Factura(Cliente cliente, List<Item> listaDeProductos, ) {
        this.cliente = cliente;
        this.listaDeProductos = listaDeProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaDeProductos() {
        return listaDeProductos;
    }

    public void setListaDeProductos(List<Item> listaDeProductos) {
        this.listaDeProductos = listaDeProductos;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public int totalCompra() {
        return (int) this.listaDeProductos.stream().mapToDouble(Item::getCostoUnitario).sum();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", listaDeProductos=" + listaDeProductos +
                ", totalCompra=" + totalCompra +
                '}';
    }
}
