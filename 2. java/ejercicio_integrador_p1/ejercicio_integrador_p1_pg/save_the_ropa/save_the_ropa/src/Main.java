import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Prenda remera = new Prenda("levi", "remera");
        Prenda pantalon = new Prenda("nike", "pantalon");

        List<Prenda> listaPrendas = new ArrayList<Prenda>();
        GuardaRopa guardaRopa = new GuardaRopa();

        listaPrendas.add(remera);
        listaPrendas.add(pantalon);
        guardaRopa.guardarPrendas(listaPrendas);
        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(0);
    }
}