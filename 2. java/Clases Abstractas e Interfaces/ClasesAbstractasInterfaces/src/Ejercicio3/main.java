package Ejercicio3;

import Ejercicio3.Clases.Animal;
import Ejercicio3.Clases.Gato;
import Ejercicio3.Clases.Perro;
import Ejercicio3.Clases.Vaca;

public class main {
    public static void main(String[] args) {
        Perro perro = new Perro("Carnivoro");
        perro.emitirSonido();
        perro.comer();

        Gato gato = new Gato("Carnivoro");
        gato.emitirSonido();
        gato.comer();

        Vaca vaca = new Vaca("Herviboro");
        vaca.emitirSonido();
        vaca.comer();

    }
}
