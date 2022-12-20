package org.example;

import java.util.ArrayList;
import java.util.List;

public class Flota implements Jugador {
  private List<NaveSimple> naves = new ArrayList<>();
  private int puntuacion = 0;
  public Flota(List<NaveSimple> naves) {
    this.naves = naves;
  }

  public List<NaveSimple> getNaves() {
    return naves;
  }

  public void agregarNave(NaveSimple nave) {
    this.naves.add(nave);
  }

  public float calcularDistancia(Coordenadas target) {
    float sum = naves.stream().map(nave -> nave.calcularDistancia(target)).reduce((a, b) -> a + b).get();
    return sum / (float) naves.size();
  }

  @Override
  public void incrementarPuntuacion() {
    this.puntuacion += 1;
  }

  @Override
  public int getPuntuacion() {
    return puntuacion;
  }
}
