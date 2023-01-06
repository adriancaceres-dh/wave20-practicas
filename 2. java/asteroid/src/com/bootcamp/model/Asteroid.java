package com.bootcamp.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Asteroid {
    private final List<IDestructor> participantes;
    private final List<int[]> coordenadas;

    public Asteroid(List<IDestructor> participantes, List<int[]> coordenadas) {
        this.participantes = participantes;
        this.coordenadas = coordenadas;
    }

    public void jugar() {
        for(int[] coordenada : coordenadas) {
            StringBuilder result = new StringBuilder();
            IDestructor ganador = new Nave();
            double dGanador = Double.MAX_VALUE;

            result.append("Cooredenadas: ").append(Arrays.toString(coordenada));
            for(IDestructor participante : participantes) {
                double distancia = participante.destruir(coordenada[0], coordenada[1]);

                if(distancia < dGanador) {
                    ganador = participante;
                    dGanador = distancia;
                }

                result.append("\n").append("Participante: ").append(participante.getNombre()).append(" - Tipo: ").append(participante.getClass().getSimpleName());
                result.append(" - Distancia: ").append(distancia);
            }

            ganador.addPunto();

            result.append("\nGANADOR: ").append(ganador.getNombre()).append(" - Tipo: ").append(ganador.getClass().getSimpleName()).append("\n");
            System.out.println(result);
        }
    }

    public void mostrarGanador() {
        IDestructor ganador = participantes.stream().max(Comparator.comparingInt(IDestructor::getPuntos)).get();
        System.out.println("MOSTRANDO GANADOR");
        System.out.println("GANADOR: " + ganador.getNombre() + " - Tipo: " + ganador.getClass().getSimpleName());
    }
}
