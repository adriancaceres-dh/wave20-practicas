import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("marca 1", "modelo 1");
        Prenda prenda2 = new Prenda("marca 2", "modelo 2");
        List<Prenda> listaPrendas = new ArrayList<>();
        listaPrendas.add(prenda1);
        listaPrendas.add(prenda2);
        Prenda prenda3 = new Prenda("marca 3", "modelo 3");
        Prenda prenda4 = new Prenda("marca 4", "modelo 4");
        List<Prenda> listaPrendas2 = new ArrayList<>();
        listaPrendas2.add(prenda3);
        listaPrendas2.add(prenda4);

        GuardaRopa guardaRopa = new GuardaRopa();

        System.out.println(guardaRopa.guardarPrendas(listaPrendas));
        System.out.println(guardaRopa.mostrarPrendas());

        System.out.println(guardaRopa.guardarPrendas(listaPrendas2));
        System.out.println(guardaRopa.mostrarPrendas());
    }
}