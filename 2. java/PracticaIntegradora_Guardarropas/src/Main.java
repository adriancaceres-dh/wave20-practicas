import java.util.*;

public class Main {
    public static void main(String[] args) {
       Prenda prenda1 = new Prenda("Nike", "N-1");
       Prenda prenda2 = new Prenda("Adidas", "A-1");
       List<Prenda> prendas = new ArrayList<>();

       prendas.add(prenda1);
       prendas.add(prenda2);

       Guardarropas guardarropas = new Guardarropas();
        System.out.println(guardarropas.guardarPrendas(prendas));
        guardarropas.mostrarRopa();
        System.out.println("---------");
        try {
            //guardarropas.devolverPrendas(5);
            guardarropas.devolverPrendas(0);
            System.out.println("prendas devueltas.");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}