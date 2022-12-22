package com.dakar;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    public Carrera(double distancia, double premioDolares, String nombre, int cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        vehiculos = new ArrayList<>();
    }

    public boolean darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
            return true;
        }
        return false;
    }
    public boolean darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculo(Vehiculo vehículo){
        return vehiculos.remove(vehículo);
    }
    public boolean eliminarVehiculoConPatente(String unaPatente){
        return vehiculos.remove(new Auto(unaPatente));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("Carrera: ** %s **", nombre.toUpperCase()));
        sb.append("\n");
        vehiculos.stream().forEach(v -> {
            sb.append(v.toString());
            sb.append("\n");
        });
        return sb.toString();
    }
}
