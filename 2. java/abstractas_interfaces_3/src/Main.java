import animales.Animal;
import animales.Gato;
import animales.Perro;
import animales.Vaca;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = List.of(new Gato(), new Perro(), new Vaca());
        animales.forEach(animal -> {
            animal.comer();
            animal.hacerRuido();
        });
    }
}