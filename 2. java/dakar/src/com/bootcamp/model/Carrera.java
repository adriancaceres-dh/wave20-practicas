package com.bootcamp.model;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
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

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    private boolean cupoLleno() {
        return vehiculos.size() >= cantidadDeVehiculosPermitidos;
    }

    private double calcularFormula(Vehiculo vehiculo) {
        double numerador = vehiculo.getVelocidad() * vehiculo.getAceleracion() / 2;
        double denominador = vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas()) * 100;
        return numerador / denominador;
    }

    private Optional<Vehiculo> obtenerVehiculoPorPatente(String patente) {
        return vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if(cupoLleno())  return;
        vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if(cupoLleno())  return;
        vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.removeIf(v -> v.getPatente().equals(patente));
    }

    public Optional<Vehiculo> definirGanador() {
        return vehiculos.stream().max(Comparator.comparingDouble(this::calcularFormula));
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> auto = obtenerVehiculoPorPatente(patente);

        if(auto.isEmpty() || auto.get() instanceof Moto) {
            System.out.println("Vehículo inválido");
            return;
        }

        socorristaAuto.socorrer((Auto)auto.get());
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> moto = obtenerVehiculoPorPatente(patente);

        if(moto.isEmpty() || moto.get() instanceof Auto) {
            System.out.println("Vehículo inválido");
            return;
        }

        socorristaMoto.socorrer((Moto)moto.get());
    }
}
