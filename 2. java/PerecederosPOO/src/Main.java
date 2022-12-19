import modelo.NoPerecedero;
import modelo.Perecedero;
import modelo.Producto;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Perecedero p1 = new Perecedero(2, "pan", 1500);
        Perecedero p2 = new Perecedero(2, "leche", 1200);
        Perecedero p3 = new Perecedero(2, "huevo", 1300);
        Perecedero p4 = new Perecedero(2, "harina", 1700);
        NoPerecedero noP1 = new NoPerecedero("tallarin", 1000, "pasta");
        NoPerecedero noP2 = new NoPerecedero("azucar", 2000, "pasta");
        NoPerecedero noP3 = new NoPerecedero("sal", 1600, "pasta");
        NoPerecedero noP4 = new NoPerecedero("lentejas", 1300, "pasta");
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(noP1);
        listaProductos.add(noP2);
        listaProductos.add(noP3);
        listaProductos.add(noP4);

        for(int i = 0; i<listaProductos.size();i++){
            System.out.println("El "+listaProductos.get(i).getNombre() +" tien un Precio de: "+listaProductos.get(i).calcular(1));
        }

    }
}