package com.bootcamp.clases;

import java.time.LocalDate;

public class BoletoViaje extends Reserva{

    String clase;


    public BoletoViaje(double precio, LocalDate fecha, String clase) {
        super(precio, fecha);
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "BoletoViaje{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                ", clase='" + clase + '\'' +
                '}';
    }
}
