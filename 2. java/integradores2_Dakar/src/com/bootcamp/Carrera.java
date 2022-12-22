package com.bootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Carrera {
    double distancia;
    int premioEnDolares;
    String nombre;
    int cantidadDeVehiculosPermitidos;
    List<Vehiculo> listaDeVehiculos;

    public Carrera() {
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", listaDeVehiculos=" + listaDeVehiculos +
                '}';
    }

    public Carrera(double distancia, int premioEnDolares, String nombre,
                   int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
    }

    public boolean verificarCupo(){
        if (!(listaDeVehiculos.size() <= cantidadDeVehiculosPermitidos))
        {
            System.out.println("No hay cupo disponible para esta carrera");
            return false;
        }
        return true;
    }

    public void darDeAltaAuto(Auto auto){
        if (verificarCupo()){
            listaDeVehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(Moto moto){
        if (verificarCupo()) {
            listaDeVehiculos.add(moto);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.listaDeVehiculos = listaDeVehiculos.stream()
                .filter(v -> !v.equals(vehiculo))
                .collect(Collectors.toList());
    }

    public void eliminarVehiculoConPatente(String patente){
        this.listaDeVehiculos = listaDeVehiculos.stream()
                .filter(v -> !v.patente.equals(patente))
                .collect(Collectors.toList());
    }

    public double calcularPuntaje(Vehiculo vehiculo){
        return vehiculo.velocidad * 0.5 * vehiculo.aceleracion
                / (vehiculo.anguloDeGiro * (vehiculo.peso) - vehiculo.ruedas);
    }

    public Double obtenerMaximoPuntaje(){
        List<Double> puntajes = (listaDeVehiculos.stream().map(this::calcularPuntaje).collect(Collectors.toList()));
        if (!puntajes.isEmpty()) return puntajes.stream().max(Comparator.comparing(Double::valueOf)).get();
        else {
            throw new RuntimeException("No hay vehiculos participando");
        }
    }
    public void correrCarrera(){
        Double maximoPuntaje = obtenerMaximoPuntaje();
        List<Vehiculo> ganadores = (listaDeVehiculos.stream().map(v -> Double.valueOf(calcularPuntaje(v))
                .equals(maximoPuntaje) ? v : null)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));

        if (ganadores.size() > 1) System.out.println("hubo un empate");
        else {
            Vehiculo vehiculoGanador = ganadores.get(0);
            String patenteVehiculoGanador = vehiculoGanador.patente;
            System.out.println("El ganador de la carrera " + nombre + " es el vehiculo de patente: "
                    + patenteVehiculoGanador + "\ngano un premio de " + premioEnDolares +" dolares");
        }
    }
}
