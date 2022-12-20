import com.bootcamp.clases.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();
        Perro perro = new Perro("Firulay");
        Vaca vaca = new Vaca("Matilda");
        Gato gato = new Gato("Garfield");

        animales.add(perro);
        animales.add(vaca);
        animales.add(gato);
        for(Animal animal: animales){
            animal.emitirSonido();
            Comer.comerAnimal(animal);
        }
    }
}