package com.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Distribuidora {

    public static Producto crearProducto(){
        Producto prod;
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        char opcion;
        do{
        System.out.println("Seleccione que tipo de producto quiere cargar: ");
        System.out.println("1.Perecedero.");
        System.out.println("2.No perecedero.");
        opcion = sc1.next().charAt(0);
        }while(opcion !='1' && opcion != '2');

        try {
            System.out.println("Nombre del producto: ");
            String nombre = sc1.nextLine();
            System.out.println("Precio del producto: ");
            double precio = sc2.nextDouble();
            if (opcion != '1') {
                System.out.println("Dias por caducar: ");
                int diasPorCaducar = sc2.nextInt();
                prod = new Perecedero(nombre, precio, diasPorCaducar);
            } else {
                System.out.println("Tipo: ");
                String tipo = sc1.nextLine();
                prod = new NoPerecedero(nombre, precio, tipo);
            }
        }catch (Exception e){
            prod = crearProducto();
        }finally {
            sc1.close();
            sc2.close();
        }

        return prod;
    }

    public static void cargarProductos(List<Producto> prods){
        int perecederos=0; int noPerecederos=0;
        while(perecederos<5 && noPerecederos<5){
            Producto prod= crearProducto();
            prods.add(prod);
            if(prod.getClass() == Perecedero.class){
                perecederos++;
            }else{
                noPerecederos++;
            }
        }
    }

    public static void imprimirTotal(List<Producto> prods) {
        try {
            double total = 0;
            int cant;
            Scanner sc = new Scanner(System.in);
            for (Producto p : prods) {
                System.out.println("¿Cuantos productos hay del nombre " + p.getNombre() + "?");
                cant = sc.nextInt();
                total += p.calcular(cant);
            }
            System.out.println("El precio total de la lista es: " + total);
        } catch (Exception e) {
            System.out.println("No se pudo calcular el total.");
        }
    }

    public static void main(String[] args){

        List<Producto> productos = new ArrayList<>();

        cargarProductos(productos);
        imprimirTotal(productos);

    }
}
