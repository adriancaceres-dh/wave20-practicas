import com.bootcamp.clases.Camisa;
import com.bootcamp.clases.GuardaRopa;
import com.bootcamp.clases.Pantalon;
import com.bootcamp.clases.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Camisa camisa = new Camisa("H&M", "A");
        Pantalon pantalon = new Pantalon("Zara", "B");
        GuardaRopa guardaRopa = new GuardaRopa();
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(camisa);
        prendas.add(pantalon);
        int nroGuardaprendas = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(nroGuardaprendas));

    }
}