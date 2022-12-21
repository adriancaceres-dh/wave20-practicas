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

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
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
        Optional<Vehiculo> vehiculoAEliminar = vehiculos
                .stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();
        if (vehiculoAEliminar.isPresent()) {
            vehiculos.remove(vehiculoAEliminar.get());
        } else {
            System.out.println("Esa patente no esta registrada a nada");
        }
    }

    public Vehiculo determinarGanador() {
        return vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::getResultado))
                .get();
    }

}
