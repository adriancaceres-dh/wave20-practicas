import com.bootcamp.model.GuardaRopa;
import com.bootcamp.model.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");

        List<Prenda> prendas = new ArrayList<>();
        Prenda prenda = new Prenda("Levis", "Campera de cuero");
        prendas.add(prenda);
        Prenda prenda2 = new Prenda("Levis", "Camisa");
        prendas.add(prenda2);

        List<Prenda> prendas2 = new ArrayList<>();
        Prenda prenda3 = new Prenda("Adidas", "Remera");
        prendas2.add(prenda3);

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(prendas);
        System.out.println("Tu codigo es: " + guardaRopa.getContador());

        guardaRopa.guardarPrendas(prendas2);
        System.out.println("Tu codigo es: " + guardaRopa.getContador());

        guardaRopa.mostrarPrendas();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su codigo");
        int codigo = scanner.nextInt();

        System.out.println(guardaRopa.devolverPrendas(codigo));

    }
}