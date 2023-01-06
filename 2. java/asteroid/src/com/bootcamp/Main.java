package com.bootcamp;

import com.bootcamp.model.Asteroid;
import com.bootcamp.model.Flota;
import com.bootcamp.model.IDestructor;
import com.bootcamp.model.Nave;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Nave nave1 = new Nave("Nave1", 4, 9);
        Nave nave2 = new Nave("Nave2", 2, 4);
        Flota flota1 = new Flota("Flota1", List.of(new Nave(5, 8), new Nave(7, 1)));
        Flota flota2 = new Flota("Flota2", List.of(new Nave(3, 5), new Nave(2, 4)));

        List<IDestructor> participantes = List.of(nave1, nave2, flota1, flota2);
        List<int[]> coordenadas = List.of(new int[]{2,7}, new int[]{7,9}, new int[]{5,1}, new int[]{5,5}, new int[]{0,2});

        Asteroid juego = new Asteroid(participantes, coordenadas);

        juego.jugar();
        juego.mostrarGanador();
    }
}
