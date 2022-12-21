package com.bootcamp;

import com.bootcamp.localizador.RepoLocalizadores;
import com.bootcamp.reserva.Reserva;
import com.bootcamp.reserva.TipoReserva;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente gonchi = new Cliente("AR-437102", "Gonzalo Barreiro");

        Reserva r1 = new Reserva("r1", TipoReserva.PASAJE, 800);
        Reserva r2 = new Reserva("r2", TipoReserva.HOTEL, 400);
        Reserva r3 = new Reserva("r3", TipoReserva.TRASLADOS, 90);
        Reserva r4 = new Reserva("r4", TipoReserva.ALIMENTACION, 300);

        RepoLocalizadores.addLocalizador(LocalDate.of(19,5,8), gonchi, List.of(r1,r2,r3,r4));

        Reserva r5 = new Reserva("r5", TipoReserva.PASAJE, 800);
        Reserva r6 = new Reserva("r6", TipoReserva.PASAJE, 800);
        Reserva r7 = new Reserva("r7", TipoReserva.HOTEL, 400);
        Reserva r8 = new Reserva("r8", TipoReserva.HOTEL, 400);

        RepoLocalizadores.addLocalizador(LocalDate.of(20,1,15), gonchi, List.of(r5,r6,r7,r8));

        Reserva r9 = new Reserva("r9", TipoReserva.PASAJE, 1800);

        RepoLocalizadores.addLocalizador(LocalDate.of(22,5,27), gonchi, List.of(r9));
    }
}