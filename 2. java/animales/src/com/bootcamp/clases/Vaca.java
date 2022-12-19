package com.bootcamp.clases;

import com.bootcamp.interfaces.IHerbivoro;

public class Vaca extends Animal implements IHerbivoro {
    public Vaca(String tipo) {
        super(tipo);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Vaca comiendo hierba");
    }
}
