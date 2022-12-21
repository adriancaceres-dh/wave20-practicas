package ejercDistribuidora;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        List<Producto> productosList = new ArrayList<>();

        Producto perecedero1 = new Perecedero("Salmon",15.00,1);
        Producto perecedero2 = new Perecedero("Salmon",17.00,2);
        Producto perecedero3 = new Perecedero("Salmon",20.00,2);
        Producto perecedero4 = new Perecedero("Salmon",20.00,2);
        Producto perecedero5 = new Perecedero("Salmon",20.00,3);
        Producto noPerecedero1 = new NoPerecedero("Lata de Atun",18.0,"no perecedero");
        Producto noPerecedero2 = new NoPerecedero("Lata de Atun",20.0,"no perecedero");
        Producto noPerecedero3 = new NoPerecedero("Lata de Atun",12.0,"no perecedero");
        Producto noPerecedero4 = new NoPerecedero("Lata de Atun",11.0,"no perecedero");
        Producto noPerecedero5 = new NoPerecedero("Lata de Atun",19.0,"no perecedero");

        productosList.add(perecedero1);
        productosList.add(perecedero2);
        productosList.add(perecedero3);
        productosList.add(perecedero4);
        productosList.add(perecedero5);
        productosList.add(noPerecedero1);
        productosList.add(noPerecedero2);
        productosList.add(noPerecedero3);
        productosList.add(noPerecedero4);
        productosList.add(noPerecedero5);

        double suma = 0;

        for (Producto producto : productosList){
             suma += producto.getPrecio();
        }

        System.out.println("Precio total: $" + suma);
    }
}
