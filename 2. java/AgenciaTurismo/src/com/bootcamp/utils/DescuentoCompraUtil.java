package com.bootcamp.utils;

import com.bootcamp.Cliente;
import com.bootcamp.Localizador;

import java.util.List;
import java.util.stream.Collectors;

public class DescuentoCompraUtil {

    public static Localizador obtenerLocalizadorConDescuentoAplicado(Localizador localizador, List<Localizador> localizadores) {
        if (clienteAdquirioPaqueteCompleto(localizador)) {
            localizador.aplicarDescuento(10);
            return localizador;
        }

        if (clienteAdquirioDosReservasHotelODosBoletosViaje(localizador)) {
            localizador.aplicarDescuento(5);
            return localizador;
        }
        System.out.println("-");
        if (clienteYaAdquirioDosLocalizadores(localizador.getCliente(), localizadores)) {
            localizador.aplicarDescuento(5);
            return localizador;
        }

        return localizador;
    }

    private static boolean clienteAdquirioPaqueteCompleto(Localizador localizador) {
        return ReservasGetterUtil.getReservasHotel(localizador).size() > 0
                && ReservasGetterUtil.getReservasBoletosViaje(localizador).size() > 0
                && ReservasGetterUtil.getReservasTransporte(localizador).size() > 0
                && ReservasGetterUtil.getReservasComida(localizador).size() > 0;
    }

    private static boolean clienteAdquirioDosReservasHotelODosBoletosViaje(Localizador localizador) {
        return ReservasGetterUtil.getReservasHotel(localizador).size() > 1
                || ReservasGetterUtil.getReservasBoletosViaje(localizador).size() > 1;
    }

    private static boolean clienteYaAdquirioDosLocalizadores(Cliente cliente, List<Localizador> localizadores) {
        List<Localizador> localizadoresDelCliente = localizadores.stream()
                .filter(localizador -> localizador.getCliente().getDni().equals(cliente.getDni()))
                .collect(Collectors.toList());

        return localizadoresDelCliente.size() > 2;
    }
}
