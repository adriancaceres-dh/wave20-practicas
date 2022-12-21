import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuardaRopa ropa = new GuardaRopa();
        List<Prenda> lote1= new ArrayList<>();
        lote1.add(new Prenda("Marca1", "Modelo2"));
        lote1.add(new Prenda("Marca2", "Modelo32"));

        List<Prenda> lote2= new ArrayList<>();
        lote2.add(new Prenda("Marca1", "Modelo23"));


        List<Prenda> lote3= new ArrayList<>();
        lote3.add(new Prenda("Marca5", "Modelo2"));
        lote3.add(new Prenda("Marca2", "Modelo3"));
        lote3.add(new Prenda("Marca2", "Modelo1"));


        List<Prenda> lote4= new ArrayList<>();
        lote4.add(new Prenda("Marca2", "Modelo2"));
        lote4.add(new Prenda("Marca2", "Modelo52"));

        ropa.guardarPrendas(lote1);
        ropa.guardarPrendas(lote2);
        ropa.guardarPrendas(lote3);
        ropa.guardarPrendas(lote4);

        System.out.println("Lista de prendas CARGADAS:");

        ropa.mostrarPrendas();

        System.out.println("Ingrese un nro de lote para continuar:");
        Scanner input = new Scanner(System.in);
        int lote = input.nextInt();
        input.nextLine();
        ropa.consultaLote(lote);



    }
}