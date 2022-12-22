import com.bootcamp.Gato;
import com.bootcamp.Perro;
import com.bootcamp.Vaca;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comeCarne();
        perro.comerAnimal();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comeHierva();
        vaca.comerAnimal();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comeCarne();
        gato.comerAnimal();

    }
}