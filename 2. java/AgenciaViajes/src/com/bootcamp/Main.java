package com.bootcamp;

import com.bootcamp.productos.*;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        Cliente cliente1 = new Cliente("Roberto", "1");
        BoletoViaje b1 = new BoletoViaje(500, LocalDate.now());
        Comida c1 = new Comida(100, false);
        ReservaHotel r1 = new ReservaHotel(700,8);
        Transporte t1 = new Transporte(350,"Torcoroma");
        Localizador loc1 = new Localizador(cliente1, Arrays.asList(new Producto[] {b1, c1, r1, t1}));

        agencia.ingresarLocalizador(loc1);

        Cliente cliente2 = new Cliente("Carlos","2");
        BoletoViaje b2 = new BoletoViaje(200,LocalDate.now());
        BoletoViaje b3 = new BoletoViaje(300,LocalDate.now());
        ReservaHotel r2 = new ReservaHotel(100,5);
        ReservaHotel r3 = new ReservaHotel(400, 5);

        Localizador loc2 = new Localizador(cliente2, Arrays.asList(b2,b3,r2,r3));

        agencia.ingresarLocalizador(loc2);

    }
}