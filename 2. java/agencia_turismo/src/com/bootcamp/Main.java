package com.bootcamp;

import com.bootcamp.clases.*;
import com.bootcamp.clases.reservas.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Agencias de vaiejes
        Repositorio agencia = new Repositorio(4);

        // Clientes
        Cliente luis = new Cliente("LOG135", "Luis", "Lopez");

        // PRIMER ESCENARIO (se verifican los descuentos en los precios inicial y final)
        System.out.println();
        System.out.println("PRIMER ESCENARIO (se verifican los descuentos en los precios inicial y final)");

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

        // SEFUNDO ESCENARIO
        System.out.println();
        System.out.println("Localizadores vendidos: " + agencia.cantidadDeLocalizadoresVendidos());

        System.out.println();
        System.out.println("Reservas totales: " + agencia.cantidadTotalDeReservas());

        System.out.println();
        System.out.println("Mapa de reservas clasificadas:");
        Map<String, List<Reserva>> reservas = agencia.reservasClasificadas();
        System.out.println(reservas);

        // Suma de los precios finales de todos los localizadores
        System.out.println();
        System.out.println("Total de ventas: " + agencia.totalDeVentas());

        // La cantidad del total de ventas dividido entre el número de localizadores
        System.out.println();
        System.out.println("Promedio de todas las ventas: " + agencia.promedioTotalVentas());
    }
}
