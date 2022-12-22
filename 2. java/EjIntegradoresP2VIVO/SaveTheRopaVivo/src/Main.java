import com.bootcamp.Guardaropa;
import com.bootcamp.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Nike", "N-1");
        Prenda prenda2 = new Prenda("Puma", "P-1");
        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);

        Guardaropa guardaropa = new Guardaropa();
        System.out.println(guardaropa.guardarPrendas(listaPrendas));
        guardaropa.mostrarRopa();
        System.out.println("---");
        try {
            System.out.println(guardaropa.devolverPrendas(5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}