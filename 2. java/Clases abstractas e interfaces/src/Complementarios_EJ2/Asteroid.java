package Complementarios_EJ2;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Asteroid {
    private Map<Integer, Participante> participantes;

    public Asteroid() {
        this.participantes = new HashMap<>();
    }

    public Nave ataqueAsteroide(int[] coordenadas) {
        LinkedList<Participante> jugadores = new LinkedList<>(participantes.values());
        Nave naveMasCerca = null;
        double distanciaMasCerca = Integer.MAX_VALUE;
        for (int i = 0; i < jugadores.size(); i++) {
            LinkedList<Nave> navesJugador = jugadores.get(i).getNavesJugador();
            for (int k = 0; k < navesJugador.size(); k++) {
                Nave naveActual = navesJugador.get(k);
                int[] coordenadax1y1 = naveActual.getCoordenadas()[0];
                int[] coordenadax2y2 = naveActual.getCoordenadas()[1];
                double distancia = Math.sqrt(Math.pow(coordenadax1y1[0] - coordenadax2y2[0], 2) + Math.pow(coordenadax1y1[1] - coordenadax2y2[1], 2));
                if (distancia < distanciaMasCerca) {
                    distanciaMasCerca = distancia;
                    naveMasCerca = navesJugador.get(k);
                }
            }
        }
        return naveMasCerca;
    }
}
