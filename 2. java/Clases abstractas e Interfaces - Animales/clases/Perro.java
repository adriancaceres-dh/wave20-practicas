package com.bootcamp.clases;

import com.bootcamp.interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }
}
