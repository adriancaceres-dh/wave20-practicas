

import model.GuardaRopa;
import model.Prenda;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Prenda p1 = new Prenda("adidas", "verano");
        Prenda p2 = new Prenda("nike", "invierno");
        Prenda p3 = new Prenda("puma", "verano");
        List<Prenda> listaPrendas = Arrays.asList(p1,p2,p3);
        List<Prenda> lista2 = Arrays.asList(p1,p3);
        GuardaRopa g1 = new GuardaRopa();


        g1.guardarPrendas(listaPrendas);
        g1.guardarPrendas(lista2);
        g1.mostrarPrendas();
        System.out.print("buscar por key: ");
        g1.devolverPrendas(1);

    }
}