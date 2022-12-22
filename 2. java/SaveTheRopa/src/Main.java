import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> ropa1 = new ArrayList<>(Arrays.asList(new Prenda("Adidas","camiseta"),
                new Prenda("Nike","Short")));
        List<Prenda> ropa2 = new ArrayList<>(Arrays.asList(new Prenda("Puma", "medias"),
                new Prenda("Reebok", "Zapatos")));
        Guardarropa ropero = new Guardarropa();

        ropero.guardarPrendas(ropa1);
        ropero.guardarPrendas(ropa2);

        System.out.println(ropero.mostrarPrendas());

        System.out.println(ropero.devolverPrendas(1).toString());
        System.out.println(ropero.devolverPrendas(2).toString());
    }
}