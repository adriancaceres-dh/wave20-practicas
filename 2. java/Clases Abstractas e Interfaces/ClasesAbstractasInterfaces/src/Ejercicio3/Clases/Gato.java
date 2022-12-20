package Ejercicio3.Clases;

import Ejercicio3.Interfaces.IComer;
import Ejercicio3.Interfaces.ISonido;

public class Gato extends Animal implements ISonido, IComer {


    public Gato(String gustoAlimenticio) {
        super(gustoAlimenticio);
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo carne");
    }
}
