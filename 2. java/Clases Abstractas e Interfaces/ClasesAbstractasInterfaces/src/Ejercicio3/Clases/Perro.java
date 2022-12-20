package Ejercicio3.Clases;

import Ejercicio3.Interfaces.IComer;
import Ejercicio3.Interfaces.ISonido;

public class Perro extends Animal implements ISonido, IComer {


    public Perro(String gustoAlimenticio) {
        super(gustoAlimenticio);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }


    @Override
    public void comer() {
        super.setAdaptadorComer(new AdaptadorComer(super.getGustoAlimenticio()));
        super.getAdaptadorComer().comer();
    }
}
