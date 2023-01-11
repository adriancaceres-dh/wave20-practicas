package ejercicio2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Distribuidora
{
    public static void main(String[] args) throws Exception {
        List<Producto> productoList = new ArrayList<>(

        );

        Producto carne = new Perecedero("Carne",1500,3);
        Producto hamburgesa = new Perecedero("Hamburgesa",1200,2);
        Producto avena = new NoPerecedero("Avena",500,"Comida");
        Producto agua = new NoPerecedero("Agua",300,"Bebida");
        Producto manzana = new Perecedero("Manzana",600,7);

        productoList.add(carne);
        productoList.add(hamburgesa);
        productoList.add((avena));
        productoList.add(agua);
        productoList.add(manzana);
        for (Producto producto: productoList
             ) {
            producto.calcular(3);
        }
    }
}
