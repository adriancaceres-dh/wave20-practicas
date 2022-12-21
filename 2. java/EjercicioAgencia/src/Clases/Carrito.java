package Clases;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    double precio;
    List<Reserva> reservas;
    List<Descuento> descuentos;

    public double calcularPrecio(Cliente cliente){
        //Tuve en cuenta que todos los descuentos son acumulables
        //Creo que hubiera sido mejor pensar la logica de mi aplicacion con un patron de diseño Decorator
        //Falta implementar el ultimo descuento (ultimos dos localizadores)
        precio = reservas.stream().mapToDouble(res -> res.getPrecio()).sum();
        for(Descuento descuento : descuentos){
            precio = descuento.aplicarDescuentoSiCorresponde(reservas,precio, cliente);
        }
        return precio;
    }
    public Carrito() {
        this.reservas = new ArrayList<>();
        this.descuentos = new ArrayList<>();

        descuentos.add(new DescuentoDosHotelesDosViajes());
        descuentos.add(new DescuentoPaquete());
        descuentos.add(new DescuentoClienteFrecuente());
    }

    public boolean addReserva(Reserva reserva){
        return reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double calcularPrecioSinDescuentos() {
        return reservas.stream().mapToDouble(res -> res.getPrecio()).sum();
    }
}
