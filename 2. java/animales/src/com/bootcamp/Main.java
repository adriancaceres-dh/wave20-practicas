package com.bootcamp;

import com.bootcamp.clases.Gato;
import com.bootcamp.clases.Perro;
import com.bootcamp.clases.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Mamífero");
        Gato gato = new Gato("Mamífero");
        Vaca vaca = new Vaca("Mamífero");

        // Sonidos
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        // Alimento
        perro.comerCarne();
        perro.comerAnimal(gato);
        gato.comerCarne();
        vaca.comerHierba();
    }
}
