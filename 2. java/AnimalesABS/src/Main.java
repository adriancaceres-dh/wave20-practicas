import modelo.Comer;
import modelo.Gato;
import modelo.Perro;
import modelo.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro p = new Perro("carnivoro");
        Gato g = new Gato("carnivoro");
        Vaca v = new Vaca("hervivoro");
        Comer c = new Comer();


        p.emitirSonido();
        g.emitirSonido();
        v.emitirSonido();

        System.out.println( c.comerAnimal(p));
        System.out.println( c.comerAnimal(g));
        System.out.println(c.comerAnimal(v));


    }
}