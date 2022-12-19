package com.bootcamp;

public class Distribuidora {
    public static void main(String[] args) {
        double precioTotal = 0;

        Producto[] productos = {
                new Perecedero("Frijoles", 5500, 2),
                new Perecedero("Yuca", 4500, 3),
                new Perecedero("Chocolate", 9000, 1),
                new Perecedero("Mazorca", 1500, 3),
                new Perecedero("Arroz", 11500, 3),
                new NoPerecedero("Clorox", 3500, "Limpieza"),
                new NoPerecedero("Camiseta", 15000, "Vestimenta"),
                new NoPerecedero("Zapatos", 23500, "Vestimenta"),
                new NoPerecedero("Computadora", 21500, "Tecnología"),
                new NoPerecedero("Medias", 22500, "Vestimenta")
        };

        for(Producto producto: productos){
            precioTotal += producto.calcular(5);
            System.out.println("Precio total acumulado: $" + precioTotal);
        }
    }
}
