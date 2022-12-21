package com.bootcamp.productos;
import java.time.LocalDate;
public class BoletoViaje extends Producto{
    LocalDate fecha;

    public BoletoViaje(double precio, LocalDate fecha) {
        super(precio);
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
