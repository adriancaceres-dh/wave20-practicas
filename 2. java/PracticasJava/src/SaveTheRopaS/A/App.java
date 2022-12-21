package SaveTheRopaS.A;

import java.util.List;

public class App {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(List.of(new Prenda("aaaa","b")));
        guardaRopa.guardarPrendas(List.of(new Prenda("dddd","ccccc")));

        guardaRopa.mostrarPrendas();

    }
}
