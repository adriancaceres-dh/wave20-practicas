package com.bootcamp;

import com.bootcamp.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Vehiculo auto1 = new Auto(200, 10, 50, "AUTO1");
        Vehiculo moto1 = new Moto(170, 70, 60, "MOTO1");

        SocorristaAuto socorristaAuto = new SocorristaAuto(100, 20, 30, "SO_AUTO", 1200, 6);
        SocorristaMoto socorristaMoto = new SocorristaMoto(100, 20, 30, "SO_MOTO", 1200, 6);

        Carrera carrera = new Carrera(5000, 2000, "Carrera", 4,
                new ArrayList<>(List.of(auto1, moto1)), socorristaAuto, socorristaMoto);

        carrera.darDeAltaAuto(230, 40, 30, "AUTO2");
        carrera.darDeAltaMoto(220, 20, 80, "MOTO2");

        carrera.socorrerAuto("AUTO1");
        carrera.socorrerMoto("MOTO2");

        Optional<Vehiculo> ganador = carrera.definirGanador();

        System.out.println(ganador.map(vehiculo -> "Ganador con patente: " + vehiculo.getPatente()).orElse("No hay ganador"));
    }
}
