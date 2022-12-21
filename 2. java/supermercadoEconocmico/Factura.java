package supermercadoEconocmico;

import java.util.ArrayList;
import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Producto> productos;

    private int totalDeLaCompra;

    public Factura(Cliente cliente, int totalDeLaCompra) {
        this.cliente = cliente;
        this.totalDeLaCompra = totalDeLaCompra;
        this.productos = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getTotalDeLaCompra() {
        return totalDeLaCompra;
    }

    public void setTotalDeLaCompra(int totalDeLaCompra) {
        this.totalDeLaCompra = totalDeLaCompra;
    }

    public void agregarProducto(Producto product){
        this.productos.add(product);
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", productos=" + productos +
                ", totalDeLaCompra=" + totalDeLaCompra +
                '}';
    }
}
