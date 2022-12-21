package poo.java;

import java.util.ArrayList;
import java.util.List;

public class Equipos {

    List<Jugador> jugadores;
    String pais;

    public Equipos(String pais) {
        this.pais = pais;
        jugadores = new ArrayList<>();
    }
}
