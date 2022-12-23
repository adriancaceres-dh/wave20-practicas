package com.bootcamp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        Supermercado supermercado = new Supermercado();

        Cliente cliente1 = new Cliente("11111111", "Juan", "Fernandez");
        Cliente cliente2 = new Cliente("22222222", "Ivan", "Gonzalez");
        Cliente cliente3 = new Cliente("33333333", "Jeronimo", "Martinez");

        supermercado.agregarCliente(cliente1);
        supermercado.agregarCliente(cliente2);
        supermercado.agregarCliente(cliente3);

        supermercado.imprimirClientes();
        System.out.println();
        supermercado.eliminarCliente("22222222");
        System.out.println();
        supermercado.imprimirClientes();

        System.out.println();
        System.out.println("Ingrese dni de cliente para buscarlo");
        String dni = teclado.nextLine();
        supermercado.mostrarCliente(dni);


    }
}
