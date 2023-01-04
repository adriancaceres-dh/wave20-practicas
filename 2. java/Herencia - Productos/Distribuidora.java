package com.bootcamp;

public class Distribuidora {
    public static void main(String[] args) {

        double precioTotal = 0;

        Producto[] productos = {
                new Perecedero("Pan", 148, 28),
                new Perecedero("Leche", 58, 2),
                new Perecedero("Manteca", 210, 11),
                new Perecedero("Queso de Untar", 110, 3),
                new NoPerecedero("Championes", 3500, "Ropa"),
                new NoPerecedero("Reloj", 15000, "Accesorio"),
                new NoPerecedero("Papel Higienico", 23500, "Limpieza"),
                new NoPerecedero("Cargador", 22500, "Electronica")
        };

        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);

        }
        System.out.println("Precio total acumulado: $" + precioTotal);
    }
}