package SeveTheRopa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Zara","Blusa");
        Prenda prenda2 = new Prenda("Rener","Falda");
        GuardaRopa guardaRopa = new GuardaRopa(1);
        List<Prenda> listaPrenda = new ArrayList<>();
        List<Prenda> listaPrenda1 = new ArrayList<>();
        listaPrenda.add(prenda1);
        guardaRopa.addPrendas(1,listaPrenda);
        listaPrenda1.add(prenda2);
        listaPrenda1.add(prenda1);
        guardaRopa.addPrendas(2,listaPrenda1);
        guardaRopa.mostrarPrendas();
        List<Prenda> listaDePrendasGuardadas = guardaRopa.devolverPrendas(2);
        System.out.println("Prendas guardadas con la clave " + 2);
        listaDePrendasGuardadas.stream().forEach(System.out::println);
        Integer k = guardaRopa.guardarPrendas(listaPrenda1);
        System.out.println("clave del guardarropas: " + k);

    }
}
