import com.bootcamp.GuardaRopa;
import com.bootcamp.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda p1 = new Prenda("Adidas", "A1");
        Prenda p2 = new Prenda("Nike", "N1");
        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(p1);
        listaPrendas.add(p2);

        GuardaRopa guardaRopa = new GuardaRopa();
        int codigo = guardaRopa.guardarPrendas(listaPrendas);

        guardaRopa.mostrarPrendas();

        System.out.println(guardaRopa.devolverPrendas(codigo));

    }
}