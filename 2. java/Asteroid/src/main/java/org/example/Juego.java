package org.example;

import java.util.ArrayList;
import java.util.List;

public class Juego {
  private List<Participante> participantes = new ArrayList<>();
  private Coordenadas[] coordenadasAsteroide;
  public void agregarParticipante(Participante participante) {
    this.participantes.add(participante);
  }

  public void setCoordenadasAsteroide(Coordenadas[] coordenadasAsteroide) {
    this.coordenadasAsteroide = coordenadasAsteroide;
  }

  public void iniciarJuego() {
    Participante ganadorJuego = null;
    float distanciaMinima = Float.MAX_VALUE;

    for (Coordenadas coordenadas : coordenadasAsteroide) {
      float minCoordenada =  Float.MAX_VALUE;
      Participante ganadorCoordenada = null;
      for (Participante participante : participantes) {
        float distancia = participante.jugar(coordenadas);
        if (distancia < minCoordenada) {
          minCoordenada = distancia;
          ganadorCoordenada = participante;
        }
        System.out.println("El participante " + participante.getNombre() + " obtuvo una distancia de " + distancia + " al asteroide en la coordenada " + coordenadas);
      }
      System.out.println("El ganador de la coordenada " + coordenadas + " es " + ganadorCoordenada.getNombre());
      ganadorCoordenada.incrementarPuntuacion();
    }

  }

  public void obtenerGanador() {
    Participante ganador = null;
    int puntuacionMaxima = 0;
    for (Participante participante : participantes) {
      if (participante.getPuntuacion() > puntuacionMaxima) {
        puntuacionMaxima = participante.getPuntuacion();
        ganador = participante;
      }
    }
    System.out.println("El ganador del juego es " + ganador.getNombre() + " con " + ganador.getPuntuacion() + " puntos");
  }

}
