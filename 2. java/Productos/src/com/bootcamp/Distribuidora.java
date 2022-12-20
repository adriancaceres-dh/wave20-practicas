package com.bootcamp;

public class Distribuidora {
    public static void main(String args []){
        Producto[] productos = new Producto[10];
        productos[0] = new Perecedero("Manteca", 100, 3);
        productos[1] = new Perecedero("Queso crema", 150, 2);
        productos[2] = new Perecedero("Leche", 200, 1);
        productos[3] = new Perecedero("Queso", 250, 5);
        productos[4] = new Perecedero("Alimento", 300, 10);
        productos[5] = new NoPerecedero("Lentejas", 80, "");
        productos[6] = new NoPerecedero("Arroz", 85, "");
        productos[7] = new NoPerecedero("Frutos secos", 150, "");
        productos[8] = new NoPerecedero("Harina", 70, "");
        productos[9] = new NoPerecedero("Condimentos", 100, "");

        double precioTotal = 0;
        for(Producto p: productos){
            System.out.println(p.toString());
            precioTotal = precioTotal + p.calcular(1);
        }
        System.out.println();
        System.out.println("Precio total: " + precioTotal);
    }
}
