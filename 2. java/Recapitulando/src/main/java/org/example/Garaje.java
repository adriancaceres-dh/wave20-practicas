package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
  private String id;
  private List<Vehiculo> vehiculos = new ArrayList<>();

  public Garaje(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void agregarVehiculo(Vehiculo vehiculo) {
    vehiculos.add(vehiculo);
  }

  public List<Vehiculo> getVehiculos() {
    return vehiculos;
  }

  public void setVehiculos(List<Vehiculo> vehiculos) {
    this.vehiculos = vehiculos;
  }

  public void imprimirVehiculos() {
    for (Vehiculo vehiculo : vehiculos) {
      System.out.println(vehiculo.getMarca() + " " + vehiculo.getModelo() + " " + vehiculo.getCosto());
    }
  }
}
