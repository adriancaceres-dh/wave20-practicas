package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AgenciaViajes agencia = new AgenciaViajes();
        Cliente laura = new Cliente("482553332", "Laura", "Novillo");
        List<List<Integer>> reservas1 = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(1500);
            reservas1.add(l);
        }
        // reservas1 = [[1500], [1500], [1500], [1500]]

        Localizador localizadorCompleto = new Localizador(laura, reservas1);
        agencia.contratarLocalizador(laura, localizadorCompleto);

        List<List<Integer>> reservas2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> l = new ArrayList<>();
            reservas2.add(l);
        }

        reservas2.get(0).add(2500);
        reservas2.get(0).add(500);
        reservas2.get(2).add(400);
        reservas2.get(2).add(150);

        // 2850 +
        Localizador localizadorHotelYViaje = new Localizador(laura, reservas2);
        agencia.contratarLocalizador(laura, localizadorHotelYViaje);

        List<List<Integer>> reservas3 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Integer> l = new ArrayList<>();
            reservas3.add(l);
        }
        reservas3.get(3).add(450);

        Localizador localizadorUnaReserva = new Localizador(laura, reservas3);
        agencia.contratarLocalizador(laura, localizadorUnaReserva);

    }
}