package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<> ();
        clientes.add(new Cliente("34442", "Gustavo", "Ramirez"));
        clientes.add(new Cliente("234234", "Luis", "Estebanez"));
        clientes.add(new Cliente("546745", "Hugo", "Morales"));

        Scanner scanner = new Scanner(System.in);
        boolean prendido = true;

        while(prendido) {
            System.out.println("""
                
                ---Bienvenido a la bd del supermercado---\s
                 Elija que busca hacer:
                1- Agregar clientes
                2- Buscar cliente
                3- Ver clientes
                4- Eliminar cliente
                5- Salir""");
            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Cual es el nombre del cliente nuevo?");
                    scanner.nextLine();
                    String nombreNuevo = scanner.nextLine();
                    System.out.println("Y el apellido?");
                    String apellidoNuevo = scanner.next();
                    System.out.println("Finalmente, cual es el dni?");
                    scanner.nextLine();
                    String dniNuevo = scanner.nextLine();
                    clientes.add(new Cliente(dniNuevo,nombreNuevo,apellidoNuevo));
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Cual es el dni del cliente que busca?");
                    String dniBusqueda = scanner.nextLine();
                    Cliente clienteBusqueda = clientes.stream().filter(cliente -> cliente.getDni().equals(dniBusqueda))
                            .findFirst().orElse(null);
                    if (clienteBusqueda == null) {
                        System.out.println("El cliente no fue encontrado");
                        break;
                    }
                    System.out.println("Datos del cliente ==> " + clienteBusqueda);
                    break;
                case 3:
                    clientes.forEach(System.out::println);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Cual es el dni del cliente que desea eliminar?");
                    String dniEliminar = scanner.nextLine();
                    Cliente clienteEliminar = clientes.stream().filter(cliente -> cliente.getDni().equals(dniEliminar))
                            .findFirst().orElse(null);
                    if (clienteEliminar == null) {
                        System.out.println("El cliente no fue encontrado");
                        break;
                    }
                    clientes.remove(clienteEliminar);
                    System.out.println("El cliente fue eliminado correctamente");
                    break;
                case 5:
                    prendido = false;
                    break;
                default:
                    System.out.println("Seleccione una opcion correcta");
                    break;
            }
        }
    }
}