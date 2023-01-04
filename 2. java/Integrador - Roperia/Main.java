package bootcamp2;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> listaPrendas = new ArrayList<>();

        listaPrendas.add(new Prenda("Gucci", "Campera"));
        listaPrendas.add(new Prenda("Puma", "Short"));

        int numeroId =guardaRopa.guardarPrendas(listaPrendas);
        System.out.println("Su número de identificación es: " + numeroId);
        guardaRopa.mostrarPrendas();
        System.out.println("Las prendas con el número ingresado son: " + guardaRopa.devolverPrendas(numeroId));

    }
}