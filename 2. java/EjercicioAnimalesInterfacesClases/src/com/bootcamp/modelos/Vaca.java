package com.bootcamp.modelos;

public class Vaca extends Animal implements IHerviboro {
    public Vaca(String nombre, int edad) {
        super(nombre, edad);
    }


    @Override
    public String emitirSonido() {
        return "Muuu!";
    }

    @Override
    public String comerHierba() {
        return "Soy una vaca y estoy comiendo hierba";
    }
}
