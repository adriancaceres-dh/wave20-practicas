package org.example;

public class SocorristaMoto extends Socorrista {
  public void socorrer(Vehiculo moto) {
    System.out.println("Socorriendo moto " + moto.getPatente());
  }
}
