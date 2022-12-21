package com.bootcamp.imprimir;

import com.bootcamp.localizador.Localizador;

public class ImprimirPorConsola {
    public static void imprimir(Localizador localizador) {
        System.out.println();
        System.out.println(String.format("DETALLE DE RESERVA DE VIAJE      Núm: %4d", localizador.getId()));
        System.out.println();
        System.out.println(localizador.getCliente().toString());
        localizador.getReservas().stream().forEach(r -> {
            System.out.println(r.toString());
        });

        System.out.println();
        System.out.println(String.format("                    Subtotal: $ %10.2f", localizador.subTotal()));
        localizador.descuentosAplicados().stream().forEach(d -> {
            System.out.println(String.format("                   Descuento: $ %10.2f", -d.aplicarDescuento()));
        });

        System.out.println();
        System.out.println(String.format("               IMPORTE TOTAL: $ %10.2f", localizador.importeFinal()));
    }
}
