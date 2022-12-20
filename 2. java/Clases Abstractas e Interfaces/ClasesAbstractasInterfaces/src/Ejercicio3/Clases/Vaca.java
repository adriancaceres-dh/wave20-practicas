package Ejercicio3.Clases;

import Ejercicio3.Interfaces.IComer;
import Ejercicio3.Interfaces.ISonido;

public class Vaca extends Animal implements ISonido, IComer {


    public Vaca(String gustoAlimenticio) {
        super(gustoAlimenticio);
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comer() {
        System.out.println("Comiendo hierbas");
    }
}
