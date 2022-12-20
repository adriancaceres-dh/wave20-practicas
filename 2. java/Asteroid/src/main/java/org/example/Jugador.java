package org.example;

public interface Jugador {
  public float calcularDistancia(Coordenadas target);
  public void incrementarPuntuacion();

  int getPuntuacion();
}
