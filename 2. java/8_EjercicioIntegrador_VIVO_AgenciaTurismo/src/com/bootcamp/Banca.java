package com.bootcamp;

public class Banca extends Persona{

    // propios datos

    public Banca(String nombre) {
        super(nombre);
    }

    @Override
    public boolean jugar(int numero) {
        for (int i = 0; i < 3; i++) {
            if(numero == (int)(Math.random()*5+1)) return true;
        }
        return false;
    }
}
