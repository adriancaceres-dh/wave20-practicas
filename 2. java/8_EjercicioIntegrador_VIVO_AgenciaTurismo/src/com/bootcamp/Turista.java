package com.bootcamp;

public class Turista extends Persona{

    // propios datos

    public Turista(String nombre) {
        super(nombre);
    }

    @Override
    public boolean jugar(int numero) {
        return numero == (int)(Math.random()*5+1);
    }
}
