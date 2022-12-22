package com.bootcamp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.Map;

public class Carrera {
    double distancia;
    int premioEnUSD;
    String nombre;
    int cantidadVehiculosPermitidos;
    Map<String, Vehiculo> listaVehiculos;
    SocorristaMoto socorristaMoto;
    SocorristaAuto socorristaAuto;

    public Carrera(double distancia, int premioEnUSD, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnUSD = premioEnUSD;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = new HashMap<>();
    }

    public void darDeAltaAuto (double velocidad, double aceleracion, double AnguloDeGiro, String patente){
        if (listaVehiculos.size() < cantidadVehiculosPermitidos) {
            Auto nuevoAuto = new Auto(velocidad, aceleracion, aceleracion, patente);
            listaVehiculos.put(patente, nuevoAuto);
        }
    }

    public void darDeAltaMoto (double velocidad, double aceleracion, double AnguloDeGiro, String patente) {
        if (listaVehiculos.size() < cantidadVehiculosPermitidos) {
            Moto nuevaMoto = new Moto(velocidad, aceleracion, aceleracion, patente);
            listaVehiculos.put(patente, nuevaMoto);
        }
    }

    public void eliminarVehiculo (Vehiculo vehiculo) {
        eliminarVehiculo(vehiculo.patente);
    }

    public void eliminarVehiculo (String patente) {
        listaVehiculos.remove(patente);
    }

    public Vehiculo ganador () {
        if (!listaVehiculos.isEmpty()) {
            return listaVehiculos.values().stream().max(Comparator.comparingDouble(Vehiculo::potencial)).get();
        }
        return null;
    }

    public void socorrerAuto (String patente) {
        Vehiculo aSocorrer = listaVehiculos.get(patente);
        if (aSocorrer instanceof Auto) socorristaAuto.socorrer((Auto) aSocorrer);
    }

    public void socorrerMoto (String patente) {
        Vehiculo aSocorrer = listaVehiculos.get(patente);
        if (aSocorrer instanceof Moto) socorristaMoto.socorrer((Moto) aSocorrer);
    }
}
