package SupermercadoElEconomico;

import java.util.LinkedList;
import java.util.List;

public class Factura {
    private int codigoFactura;
    private Cliente cliente;
    List<Item> listaCompra;
    private int totalCompra;

    public Factura(int codigoFactura, Cliente cliente, int totalCompra) {
        this.codigoFactura = codigoFactura;
        this.cliente = cliente;
        this.listaCompra = new LinkedList<>();
        this.totalCompra = totalCompra;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaCompra() {
        return listaCompra;
    }

    public void agregarCompra(Item nuevaCompra) {
        listaCompra.add(nuevaCompra);
    }

    public int getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(int totalCompra) {
        this.totalCompra = totalCompra;
    }
}
