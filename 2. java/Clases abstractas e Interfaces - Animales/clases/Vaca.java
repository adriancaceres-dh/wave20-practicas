package com.bootcamp.clases;

import com.bootcamp.interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }
}
