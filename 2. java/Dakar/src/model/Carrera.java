package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Falta agregar a los socorristas, no llegue a terminarlo
public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private Set<Vehiculo> vehiculos;

    public boolean darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(cantidadDeVehiculosPermitidos > vehiculos.size()){
            return vehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
        }
        return false;

    }

    public boolean darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        if(cantidadDeVehiculosPermitidos > vehiculos.size()){
            return vehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
        }
        return false;
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo){
        return vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        vehiculos = vehiculos.stream().filter(ve->ve.getPatente()!=patente).collect(Collectors.toSet());
        System.out.println(vehiculos);
    }

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new HashSet<>();
    }

    public void imprimirVehiculosAnotados() {
        System.out.println(vehiculos);
    }
}
