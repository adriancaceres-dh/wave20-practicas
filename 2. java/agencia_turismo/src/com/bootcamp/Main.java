package com.bootcamp;

import com.bootcamp.clases.*;
import com.bootcamp.clases.reservas.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Agencias de vaiejes
        Repositorio agencia = new Repositorio(4);

        // Clientes
        Cliente luis = new Cliente("LOG135", "Luis", "Lopez");

        // Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado
        System.out.println();
        List<Reserva> paqueteCompleto = new ArrayList<>(Arrays.asList(
                new ReservaHotel(),
                new ReservaComida(),
                new ReservaBoletosViaje(),
                new ReservaBoletosTransporte()
        ));
        agencia.agregarLocalizador(luis, paqueteCompleto);

        // Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior,
        // almacenar e imprimir el resultado
        System.out.println();
        List<Reserva> hotelYBoletos = new ArrayList<>(Arrays.asList(
                new ReservaHotel(),
                new ReservaHotel(),
                new ReservaBoletosViaje(),
                new ReservaBoletosViaje()
        ));
        agencia.agregarLocalizador(luis, hotelYBoletos);

        // Crear un localizador con una sola reserva para el mismo cliente.
        System.out.println();
        List<Reserva> unaReserva = new ArrayList<>(Arrays.asList(
                new ReservaComida()
        ));
        agencia.agregarLocalizador(luis, unaReserva);
    }
}
