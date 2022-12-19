package com.bootcamp;

import com.bootcamp.interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void comerVegetales() {
        System.out.println("Que rico que son los vegetales");
    }
    @Override
    public void sonido() {
        System.out.println("Muuuuuuuu");
    }
    @Override
    public void comer() {
        comerVegetales();
    }
}
