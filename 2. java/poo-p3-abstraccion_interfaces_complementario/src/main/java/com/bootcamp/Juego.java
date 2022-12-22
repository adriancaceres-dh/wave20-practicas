package com.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Juego {
    List<Nave> participantes;

    public List<Nave> getParticipantes() {
        return participantes;
    }

    public Juego() {
        participantes = new ArrayList<>();
    }

    public Juego(Nave... naves) {
        participantes = new ArrayList<>();
        participantes.addAll(Arrays.asList(naves));
    }

    public void addParticipante(Nave participante) {
        participantes.add(participante);
    }

    public void jugarTurno(double x, double y) {
        if (participantes.size() > 0) {
            //Se busca nave ganadora
            Nave naveGanadora = participantes.get(0);
            for (Nave p : participantes) {
                if (p.distancia(x,y) < naveGanadora.distancia(x,y)) naveGanadora = p;
            }
            //Se le suma 1 punto
            naveGanadora.setPuntaje(naveGanadora.getPuntaje() + 1);

            System.out.println(String.format("Participante %s gana la partida!", naveGanadora.getNombre()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("*** ASTEROIDS ***");
        participantes.forEach(p -> sb.append("\n" + p.toString()));
        return sb.toString();
    }
}
