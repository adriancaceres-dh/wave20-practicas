package com.bootcamp.localizador;

import com.bootcamp.Cliente;
import com.bootcamp.imprimir.ImprimirPorConsola;
import com.bootcamp.reserva.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepoLocalizadores {
    private static List<Localizador> localizadores = new ArrayList<>();

    public static List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public static void addLocalizador(LocalDate fecha, Cliente cliente, List<Reserva> reservas) {
        Localizador localizador = new Localizador(fecha, cliente, reservas);
        localizadores.add(localizador);
        ImprimirPorConsola.imprimir(localizador);
    }
}
