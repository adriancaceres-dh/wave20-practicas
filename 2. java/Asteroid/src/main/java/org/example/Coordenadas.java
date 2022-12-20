package org.example;

public class Coordenadas {
  private float coordenadaX;

  private float coordenadaY;

  public Coordenadas(float coordenadaX, float coordenadaY) {
    this.coordenadaX = coordenadaX;
    this.coordenadaY = coordenadaY;
  }

  public float getCoordenadaX() {
    return coordenadaX;
  }

  public void setCoordenadaX(float coordenadaX) {
    this.coordenadaX = coordenadaX;
  }

  public float getCoordenadaY() {
    return coordenadaY;
  }

  public void setCoordenadaY(float coordenadaY) {
    this.coordenadaY = coordenadaY;
  }

  @Override
  public String toString() {
    return "Coordenadas{" +
            "coordenadaX=" + coordenadaX +
            ", coordenadaY=" + coordenadaY +
            '}';
  }
}
