package com.bootcamp.clases;

import java.time.LocalDate;

public class Hotel extends Reserva{

    String nombreHotel;
    int cantEstrellas;
    public Hotel(double precio, LocalDate fecha, String nombreHotel,int cantEstrellas) {
        super(precio, fecha);
        this.cantEstrellas = cantEstrellas;
        this.nombreHotel = nombreHotel;
    }

    public int getCantEstrellas() {
        return cantEstrellas;
    }

    public void setCantEstrellas(int cantEstrellas) {
        this.cantEstrellas = cantEstrellas;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "precio=" + precio +
                ", fecha=" + fecha +
                ", nombreHotel='" + nombreHotel + '\'' +
                ", cantEstrellas=" + cantEstrellas +
                '}';
    }
}
