package SupermercadoElEconomico;

import java.util.LinkedList;
import java.util.List;

public class Factura {
    private int codigoFactura;
    private Cliente cliente;
    List<Item> listaCompra;
    private double totalCompra;

    public Factura(int codigoFactura, Cliente cliente) {
        this.codigoFactura = codigoFactura;
        this.cliente = cliente;
        this.listaCompra = new LinkedList<>();
        this.totalCompra = 0;
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

    public void setListaCompra(List<Item> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public void agregarCompra(Item nuevaCompra) {
        listaCompra.add(nuevaCompra);
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public double calcularTotalCompra() {
        return (listaCompra.stream().mapToDouble(e->e.getCantidadComprada()*e.getCostoUnitario()).sum());
    }
}
