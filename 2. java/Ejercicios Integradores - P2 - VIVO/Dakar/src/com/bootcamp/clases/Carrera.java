package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Carrera {

    String nombre;
    double distancia;
    double premioEnDolares;
    int cantidadDeVehiculosPermitidos;
    SocorristaAuto socorristaAuto;
    SocorristaMoto socorristaMoto;
    List<Vehiculo> vehiculos;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
        vehiculos = new ArrayList<>();
    }

    public boolean darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
            return true;
        }
        return false;
    }

    public boolean darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculo(Vehiculo vehículo) {
        if (vehiculos.contains(vehículo)) {
            vehiculos.remove(vehículo);
            return true;
        }
        return false;
    }

    public boolean eliminarVehiculoConPatente(String unaPatente) {
        List<Vehiculo> vehiculosAeliminar = vehiculos.stream().filter(v -> v.getPatente().equalsIgnoreCase(unaPatente)).collect(Collectors.toList());
        if (vehiculosAeliminar != null && !vehiculosAeliminar.isEmpty()) {
            vehiculos.removeAll(vehiculosAeliminar);
            return true;
        }
        return false;
    }

    public Vehiculo obtenerGanador() {
        if (!vehiculos.isEmpty()) {
            return vehiculos.stream().sorted((v, y) -> Double.compare(v.calcularValor(), y.calcularValor())).findFirst().get();
        }
        return null;
    }

    public Vehiculo buscarVehiculo(String patente) {
        if (!vehiculos.isEmpty()) {
            Optional<Vehiculo> optionalVehiculo = vehiculos.stream().filter(v -> v.getPatente().equalsIgnoreCase(patente)).findFirst();
            if (optionalVehiculo.isPresent()) {
                return optionalVehiculo.get();
            }
        }
        return null;
    }

    public boolean socorrerAuto(String patente) {
        Vehiculo vehiculo = buscarVehiculo(patente);
        if (vehiculo != null && vehiculo instanceof Auto) {
            socorristaAuto.socorrer((Auto) vehiculo);
            return true;
        }
        return false;
    }

    public boolean socorrerMoto(String patente) {
        Vehiculo vehiculo = buscarVehiculo(patente);
        if (vehiculo != null && vehiculo instanceof Moto) {
            socorristaMoto.socorrer((Moto) vehiculo);
            return true;
        }
        return false;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "nombre='" + nombre + '\'' +
                ", distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
