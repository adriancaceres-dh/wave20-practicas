import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> prendas1 = Arrays.asList(
                new Prenda("Gucci", "rojo"),
                new Prenda("Sara", "limitado"),
                new Prenda("Adidas", "mundialista")
        );

        List<Prenda> prendas2 = Arrays.asList(
                new Prenda("Nike", "deportivo"),
                new Prenda("Levis", "nuevo")
        );

        guardaRopa.guardarPrendas(prendas1);
        guardaRopa.guardarPrendas(prendas2);
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(1));
    }
}