package org.example;

public class SocorristaAuto extends Socorrista {
  public void socorrer(Vehiculo auto) {
    System.out.println("Socorriendo auto " + auto.getPatente());
  }
}
