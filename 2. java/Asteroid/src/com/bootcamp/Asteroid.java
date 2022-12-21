package com.bootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Asteroid {
    private int[][] ubicacionAsteroides;
    private List<Participante> participantes;
    private static final int MAX_SIZE = 100;

    public Asteroid(int[][] ubicacionAsteroides) {
        this.ubicacionAsteroides = ubicacionAsteroides;
        this.participantes = new ArrayList<>();
    }

    public void addParticipante(Participante participante) {
        participantes.add(participante);
    }

    public void jugar() {
        for (int[] ubicacionAsteroide : ubicacionAsteroides) {
            double distanciaMasCorta = MAX_SIZE;
            Participante participanteGanador = null;
            for (Participante participante : participantes) {
                double promedioDistancias = getDistanciaPromedioDeTodasLasNaves(participante, ubicacionAsteroide);
                if (promedioDistancias < distanciaMasCorta) {
                    distanciaMasCorta = promedioDistancias;
                    participanteGanador = participante;
                }
            }
            participanteGanador.agregarUnPuntoATodasSusNaves();
            System.out.println("Punto X: " + ubicacionAsteroide[0] + " Y: " + ubicacionAsteroide[1]);
            participantes.forEach(Participante::mostrarNaves);
        }
        mostrarResultadoFinal();
    }

    private double getDistanciaPromedioDeTodasLasNaves(Participante participante, int[] ubicacionAsteroide) {
        return participante
                .getNaves()
                .stream()
                .collect(Collectors.summarizingDouble(n -> n.obtenerDistanciaAlPunto(ubicacionAsteroide[0], ubicacionAsteroide[1])))
                .getAverage();
    }

    private void mostrarResultadoFinal() {
        List<Nave> naves = new ArrayList<>();
        for (Participante participante : participantes) {
            naves.addAll(participante.getNaves());
        }
        System.out.println("Resultado final");
        naves.stream().sorted(Comparator.comparingInt(Nave::getPuntos).reversed()).forEach(System.out::println);
    }
}
