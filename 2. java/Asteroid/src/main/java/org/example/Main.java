package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Juego juego = new Juego();
    Coordenadas coordenadas[] = {new Coordenadas(1F, 1F), new Coordenadas(2F, 2F), new Coordenadas(3F, 3F), new Coordenadas (4F, 4F), new Coordenadas(5F, 5F)};
    juego.setCoordenadasAsteroide(coordenadas);
    Participante participante1 = new Participante("Participante 1");
    Participante participante2 = new Participante("Participante 2");
    Flota flota1 = new Flota(new ArrayList<>(List.of(new NaveSimple("nave1", new Coordenadas(1.0F, 1.1F)), new NaveSimple("nave2", new Coordenadas(2.0F, 2.1F)))));
    participante1.setJugador(flota1);
    Flota flota2 = new Flota(new ArrayList<>(List.of(new NaveSimple("nave3", new Coordenadas(3.0F, 3.1F)), new NaveSimple("nave4", new Coordenadas(4.0F, 4.1F)))));
    participante2.setJugador(flota2);
    juego.agregarParticipante(participante1);
    juego.agregarParticipante(participante2);
    juego.iniciarJuego();
    juego.obtenerGanador();
  }
}