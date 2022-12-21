import savetheropa.Guardarropa;
import savetheropa.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var prendas = new ArrayList<>(List.of(
                new Prenda("M1", "buzo"),
                new Prenda("M2", "campera"))
        );
        var prendas2 = new ArrayList<>(List.of(
                new Prenda("M3", "otro buzo"),
                new Prenda("M4", "otra campera"))
        );
        var guardarropa = new Guardarropa();

        var key = guardarropa.guardarPrendas(prendas);
        guardarropa.guardarPrendas(prendas2);
        System.out.println("Guardando con key " + key);
        System.out.println("---------------------");
        System.out.println("Sacando prendas con key "+ key);
        System.out.println(guardarropa.devolverPrendas(key));
        System.out.println("---------------------");
        System.out.println("Mostrando prendas");
        guardarropa.mostrarPrendas();
    }
}