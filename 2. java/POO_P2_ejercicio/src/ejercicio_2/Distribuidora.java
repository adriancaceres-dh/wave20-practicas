package ejercicio_2;

import java.util.Arrays;

public class Distribuidora {

    public static void main(String[] args) {

        Producto[] productos = new Producto[10];

        productos[0] = new Perecedero("leche",10000,3);
        productos[1] = new Perecedero("manzana",1000,2);
        productos[2] = new Perecedero("torta",10000,4);
        productos[3] = new Perecedero("papa",10000,4);
        productos[4] = new Perecedero("yogurt",10000,2);
        productos[5] = new NoPerecedero("Computador",3000000,"Electrodometico");
        productos[6] = new NoPerecedero("Cama",800000,"Mueble");
        productos[7] = new NoPerecedero("mesa",300000,"Mueble");
        productos[8] = new NoPerecedero("Alcohol",10000,"Quimico");
        productos[9] = new NoPerecedero("Plato",8000,"Utencilios");

        Arrays.stream(productos).forEach( e -> {
            System.out.println(e.getNombre() + ": " + e.calcular(10));
        });
    }

}
