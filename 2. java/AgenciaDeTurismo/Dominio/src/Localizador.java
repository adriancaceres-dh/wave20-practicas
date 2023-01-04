import Productos.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;

public class Localizador {
    Cliente Cliente;
    Collection<Producto> ProductosComprados = new ArrayList<Producto>();
    boolean  EsClienteFrecuente;

    public Localizador(Cliente cliente, Collection<Producto> productosComprados, boolean AplicaDescuentoClienteFrecuente) {
        Cliente = cliente;
        ProductosComprados = productosComprados;
        EsClienteFrecuente = AplicaDescuentoClienteFrecuente;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }

    public Collection<Producto> getProductosComprados() {
        return ProductosComprados;
    }

    public void setProductosComprados(Collection<Producto> productosComprados) {
        ProductosComprados = productosComprados;
    }
    public double getPrecioTotal() {

        double PrecioTotal = ProductosComprados.stream().mapToDouble(Producto::getPrecio).sum();
        double PrecioConDescuentos = PrecioTotal;

        PrecioConDescuentos = aplicarDescuentoPaqueteDoble(PrecioTotal);
        PrecioConDescuentos = aplicarDescuentoPaqueteCompleto(PrecioConDescuentos);
        if(EsClienteFrecuente)
            PrecioConDescuentos = PrecioTotal - (PrecioConDescuentos/20);

        return PrecioConDescuentos;
    }
    private double aplicarDescuentoPaqueteCompleto(double PrecioTotal){
        if(ProductosComprados.stream().anyMatch(producto -> producto instanceof Hotel) &&
                ProductosComprados.stream().anyMatch(producto -> producto instanceof Comida)&&
                ProductosComprados.stream().anyMatch(producto -> producto instanceof Transporte)&&
                ProductosComprados.stream().anyMatch(producto -> producto instanceof BoletoViaje))
            PrecioTotal = PrecioTotal - (PrecioTotal/10);
        return PrecioTotal;
    }

    private double aplicarDescuentoPaqueteDoble(double PrecioTotal){
        Stream hotelStream = ProductosComprados.stream().filter(producto -> producto instanceof Hotel);
        double precioDescuentoHoteles = 0;

        if(hotelStream.count()==2)
            precioDescuentoHoteles = ProductosComprados.stream().filter(producto -> producto instanceof Hotel).mapToDouble(p-> ((Hotel)p).getPrecio()).sum()/20;
        Stream transporteStream = ProductosComprados.stream().filter(producto -> producto instanceof Transporte);
        double precioDescuentoTransporte = 0;

        if(transporteStream.count()==2)
            precioDescuentoTransporte = ProductosComprados.stream().filter(producto -> producto instanceof Transporte).mapToDouble(p-> ((Transporte)p).getPrecio()).sum()/20;

        return PrecioTotal - precioDescuentoHoteles -precioDescuentoTransporte;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                " Cliente=" + Cliente.toString() +
                ", Precio total=" + getPrecioTotal() +
                ", ProductosComprados=" + ProductosComprados.stream().map(Producto::toString) +  " " +
                "}";
    }
}
