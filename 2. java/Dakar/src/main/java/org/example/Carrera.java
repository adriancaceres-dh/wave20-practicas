package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
  private int distancia;
  private int premioEnDolares;
  private String nombre;
  private int cantidadDeVehiculosPermitidos;
  private List<Vehiculo> vehiculos;
  private SocorristaAuto socorristaAuto;
  private SocorristaMoto socorristaMoto;

  public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
    this.distancia = distancia;
    this.premioEnDolares = premioEnDolares;
    this.nombre = nombre;
    this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    this.vehiculos = new ArrayList<>();
    this.socorristaAuto = new SocorristaAuto();
    this.socorristaMoto = new SocorristaMoto();
  }

  public void socorrerAuto(String patente) {
    for (Vehiculo vehiculo : vehiculos) {
      if (vehiculo.getPatente().equals(patente)) {
        socorristaAuto.socorrer((Auto) vehiculo);
      }
    }
  }

  public void socorrerMoto(String patente) {
    for (Vehiculo vehiculo : vehiculos) {
      if (vehiculo.getPatente().equals(patente)) {
        socorristaMoto.socorrer((Moto) vehiculo);
      }
    }
  }

  public void darDeAltaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
    if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
      vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }
  }

  public void darDeAltaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
    if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
      vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }
  }

  public void eliminarVehiculo(Vehiculo vehiculo) {
    vehiculos.remove(vehiculo);
  }

  public void eliminarVehiculoConPatente(String patente) {
    vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
  }

  public Vehiculo darGanador() {
    Vehiculo ganador = null;
    double maxPuntaje = 0;
    for (Vehiculo vehiculo : vehiculos) {
      double puntaje = vehiculo.getVelocidad() * 0.5 + vehiculo.getAceleracion() /( vehiculo.getPeso() - vehiculo.getNumRuedas() * 100);
      if (puntaje > maxPuntaje) {
        maxPuntaje = puntaje;
        ganador = vehiculo;
      }
    }
    return ganador;
  }
}
