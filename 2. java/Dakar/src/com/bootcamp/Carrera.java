package com.bootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaMoto socorristaMoto;
    private SocorristaAuto socorristaAuto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            // mas correcto lanzar excepcion
            System.out.println("Cantidad máxima alcanzada");
        }

    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            // mas correcto lanzar excepcion
            System.out.println("Cantidad máxima alcanzada");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        Optional<Vehiculo> vehiculoAEliminar = obtenerVehiculoPorPatente(patente);
        if (vehiculoAEliminar.isPresent()) {
            vehiculos.remove(vehiculoAEliminar.get());
        } else {
            System.out.println("Esa patente no esta registrada a nada");
        }
    }

    private Optional<Vehiculo> obtenerVehiculoPorPatente(String patente) {
        return vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();
    }

    public Vehiculo determinarGanador() {
        return vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::getResultado))
                .get();
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> vehiculoASocorrer = obtenerVehiculoPorPatente(patente);
        if (vehiculoASocorrer.isPresent() && vehiculoASocorrer.get() instanceof Auto) {
            socorristaAuto.socorrer((Auto) vehiculoASocorrer.get());
        } else {
            System.out.println("Esa patente no esta registrada o no es un auto");
        }
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> vehiculoASocorrer = obtenerVehiculoPorPatente(patente);
        if (vehiculoASocorrer.isPresent() && vehiculoASocorrer.get() instanceof Moto) {
            socorristaMoto.socorrer((Moto) vehiculoASocorrer.get());
        } else {
            System.out.println("Esa patente no esta registrada o no es una moto");
        }
    }

}
