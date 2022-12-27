import clases.Animal;
import clases.Gato;
import clases.Perro;
import clases.Vaca;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        List<Animal> animales = Arrays.asList(gato, perro, vaca);

        animales.forEach(Animal::comer);
        animales.forEach(Animal::emitirSonido);
    }
}
