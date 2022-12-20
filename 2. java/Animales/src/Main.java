import com.bootcamp.Animal;
import com.bootcamp.Gato;
import com.bootcamp.Perro;
import com.bootcamp.Vaca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = new ArrayList<>();
        Animal gato = new Gato("Garfield");
        Animal perro = new Perro("Scobby");
        Animal vaca = new Vaca("Lola");
        animales.add(gato);
        animales.add(perro);
        animales.add(vaca);

        animales.forEach(Animal::emitirSonido);
        animales.forEach(Animal::comer);
    }
}