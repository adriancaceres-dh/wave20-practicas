package org.example;

public class Participante {
  private Jugador jugador;
  private String nombre;

  public Participante(String nombre) {
    this.nombre = nombre;
  }

  public Participante(String nombre, Jugador jugador) {
    this.nombre = nombre;
    this.jugador = jugador;
  }

  public void setJugador(Jugador jugador) {
    this.jugador = jugador;
  }

  public Jugador getJugador() {
    return jugador;
  }

  public float jugar(Coordenadas coordenadas) {
    return jugador.calcularDistancia(coordenadas);
  }

  public String getNombre() {
    return nombre;
  }

  public void incrementarPuntuacion() {
    jugador.incrementarPuntuacion();
  }

  public int getPuntuacion() {
    return jugador.getPuntuacion();
  }
}
