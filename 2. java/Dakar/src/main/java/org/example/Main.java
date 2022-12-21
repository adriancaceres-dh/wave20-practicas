package org.example;

public class Main {
  public static void main(String[] args) {
    Carrera carrera = new Carrera(100, 10000, "Gran Premio de Monaco", 20);
    carrera.darDeAltaAuto(100, 100, 100, "ABC123");
    carrera.darDeAltaAuto(100, 100, 100, "DEF456");
    carrera.darDeAltaAuto(100, 100, 100, "GHI789");
    carrera.darDeAltaMoto(100, 100, 100, "JKL012");
    carrera.darDeAltaMoto(100, 100, 100, "MNO345");
    carrera.darDeAltaMoto(100, 100, 100, "PQR678");
    carrera.socorrerAuto("ABC123");
    carrera.socorrerMoto("JKL012");
    Vehiculo ganador = carrera.darGanador();
    System.out.println("El ganador es: " + ganador.getPatente());

  }
}