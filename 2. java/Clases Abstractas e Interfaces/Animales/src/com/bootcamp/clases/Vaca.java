package com.bootcamp.clases;

import com.bootcamp.interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("comiendo hierba");
    }
}
