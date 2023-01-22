import com.bootcamp.Animal;
import com.bootcamp.Gato;
import com.bootcamp.Perro;
import com.bootcamp.Vaca;

public class Main {
    public static void main(String[] args) {


        Animal perro = new Perro("Boby");
        Animal gato = new Gato("Eicca" );
        Animal vaca = new Vaca("Lola");




        System.out.println("Animales: " + perro.emitirSonido() + perro.toString());
        System.out.println("Animales: " + gato.emitirSonido() + gato.toString());
        System.out.println("Animales: " + vaca.emitirSonido() + vaca.toString());

    }
}