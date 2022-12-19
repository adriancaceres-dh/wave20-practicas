package com.bootcamp;

import com.bootcamp.Animal;
import com.bootcamp.interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {


    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void comerCarne() {
        System.out.println("ñom ñom que rica la carne");
    }
    @Override
    public void sonido() {
        System.out.println("guau guau soy un perro guau");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
