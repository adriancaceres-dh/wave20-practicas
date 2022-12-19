package com.bootcamp.ejercicioPoo;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[10];
        productos[0] = new Perecedero("Carne",1600,2);
        productos[1] = new Perecedero("Leche",600, 1);
        productos[2] = new Perecedero("Tomate",300, 2);
        productos[3] = new Perecedero("Pollo",1000, 3);
        productos[4] = new Perecedero("Pescado",2000, 1);
        productos[5] = new NoPerecedero("Miel",1000, "endulzante");
        productos[6] = new NoPerecedero("Frijol", 500,"Granos");
        productos[7] = new NoPerecedero("Atún en lata", 800, "Enlatados");
        productos[8] = new NoPerecedero("Arroz", 600, "Granos");
        productos[9] = new NoPerecedero("Maiz", 400, "Granos");
        double sumaTotal = 0;
        Scanner scanner = new Scanner(System.in);
        int cantidadDeProductos;

        for (Producto producto: productos) {
            System.out.println("Ingrese la cantidad del productos para " + producto.getNombre());
            cantidadDeProductos = scanner.nextInt();
            sumaTotal += producto.calcular(cantidadDeProductos);
        }
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println("Suma Total = " + numberFormat.format(sumaTotal));
        System.out.println(productos[0]);
    }
}
