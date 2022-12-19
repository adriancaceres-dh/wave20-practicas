package com.bootcamp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distribuidora {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Carne", 1600, 2));
        productos.add(new Perecedero("Pescado", 1200.99, 1));
        productos.add(new Perecedero("Pollo", 1000.1, 3));
        productos.add(new Perecedero("Tomate", 375.3, 2));
        productos.add(new Perecedero("Lechuga", 200, 1));
        productos.add(new NoPerecedero("Arroz", 500, "Granos"));
        productos.add(new NoPerecedero("Choclo", 600, "Enlatados"));
        productos.add(new NoPerecedero("Harina", 200, "Harinas"));
        productos.add(new NoPerecedero("Polenta", 100, "Harinas"));
        productos.add(new NoPerecedero("Nueces", 3200, "Frutos secos"));

        Scanner scanner = new Scanner(System.in);
        double totalCompra = 0;
        NumberFormat formatter = new DecimalFormat("#0.00");

        for (Producto producto: productos) {
            System.out.println("Ingrese la cantidad de: " + producto.getNombre());
            int cantidadPorProducto = scanner.nextInt();
            totalCompra+= producto.calcular(cantidadPorProducto);
        }
        System.out.println("El total de la compra es de: " + formatter.format(totalCompra));
    }
}