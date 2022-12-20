package org.example;

public class NaveSimple implements Jugador {
  private String nombre;
  private Coordenadas coordenadas;
  private int puntuacion = 0;

  public NaveSimple(String nombre, Coordenadas coordenadas) {
    this.nombre = nombre;
    this.coordenadas = coordenadas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Coordenadas getCoordenadas() {
    return coordenadas;
  }

  public void setCoordenadas(Coordenadas coordenadas) {
    this.coordenadas = coordenadas;
  }

  public int getPuntuacion() {
    return puntuacion;
  }

  public void setPuntuacion(int puntuacion) {
    this.puntuacion = puntuacion;
  }

  public void incrementarPuntuacion() {
    this.puntuacion += 1;
  }

  public float calcularDistancia(Coordenadas target) {
    float distanciaX = target.getCoordenadaX() - this.coordenadas.getCoordenadaX();
    float distanciaY = target.getCoordenadaY() - this.coordenadas.getCoordenadaY();
    return (float) Math.sqrt(Math.pow(distanciaX, 2) + Math.pow(distanciaY, 2));
  }

  @Override
  public String toString() {
    return "NaveSimple{" +
            "nombre='" + nombre + '\'' +
            ", coordenadas=" + coordenadas +
            ", puntuacion=" + puntuacion +
            '}';
  }
}
