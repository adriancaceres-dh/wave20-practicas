package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("34442", "Gustavo", "Ramirez"));
        clientes.add(new Cliente("234234", "Luis", "Estebanez"));
        clientes.add(new Cliente("546745", "Hugo", "Morales"));

        List<Factura> facturas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean prendido = true;

        while (prendido) {
            System.out.println("""
                                    
                    ---Bienvenido a la bd del supermercado---\s
                     Elija que busca hacer:
                    1- Administrar clientes
                    2- Administrar facturas
                    3- Salir""");
            switch (scanner.nextInt()) {
                case 1 -> clientes = interfazClientes(clientes, scanner);
                case 2 -> facturas = interfazFacturas(clientes, facturas, scanner);
                case 3 -> prendido = false;
                default -> System.out.println("Seleccione una opcion valida");
            }
        }
    }

    private static List<Factura> interfazFacturas(List<Cliente> clientes, List<Factura> facturas, Scanner scanner) {
        boolean enInterfaz = true;
        while (enInterfaz) {
            System.out.println("""
                                    
                     Elija que busca hacer:\s
                    1- Agregar facturas
                    2- Volver para atras""");

            switch (scanner.nextInt()) {
                case 1 -> {
                    facturas = agregarFactura(clientes, facturas, scanner);
                }
                case 2 -> enInterfaz = false;
                default -> System.out.println("Seleccione una opcion correcta");
            }
        }
        return facturas;
    }

    private static List<Factura> agregarFactura(List<Cliente> clientes, List<Factura> facturas, Scanner scanner) {
        System.out.println("A que cliente se le quiere asociar la factura? (Escriba el dni):");
        String dniBusqueda = scanner.nextLine();
        Cliente clienteParaFactura = buscarCliente(clientes, dniBusqueda);
        if (clienteParaFactura == null) {
            System.out.println("No se encontro al cliente");
            return facturas;
        }
        return facturas;
    }

    private static List<Cliente> interfazClientes(List<Cliente> clientes, Scanner scanner) {
        boolean enInterfaz = true;
        while (enInterfaz) {
            System.out.println("""
                                    
                     Elija que busca hacer:\s
                    1- Agregar clientes
                    2- Buscar cliente
                    3- Ver clientes
                    4- Eliminar cliente
                    5- Volver para atras""");

            switch (scanner.nextInt()) {
                case 1 -> {
                    clientes = agregarCliente(clientes, scanner);
                }
                case 2 -> {
                    System.out.println("Cual es el dni del cliente que busca?");
                    String dniBusqueda = scanner.nextLine();
                    System.out.println("Datos del cliente ==> " + buscarCliente(clientes, dniBusqueda).toString());
                }
                case 3 -> clientes.forEach(System.out::println);
                case 4 -> {
                    clientes = borrarCliente(clientes, scanner);
                }
                case 5 -> enInterfaz = false;
                default -> System.out.println("Seleccione una opcion correcta");
            }
        }
        return clientes;
    }

    private static List<Cliente> borrarCliente(List<Cliente> clientes, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Cual es el dni del cliente que desea eliminar?");
        String dniEliminar = scanner.nextLine();
        Cliente clienteEliminar = buscarCliente(clientes, dniEliminar);
        if (clienteEliminar != null) {
            clientes.remove(clienteEliminar);
            System.out.println("El cliente fue eliminado correctamente");
            return clientes;
        }
        System.out.println("El cliente no se pudo eliminar");
        return clientes;
    }

    private static Cliente buscarCliente(List<Cliente> clientes, String dniBusqueda) {
        Cliente clienteBusqueda = clientes.stream().filter(cliente -> cliente.getDni().equals(dniBusqueda))
                .findFirst().orElse(null);
        if (clienteBusqueda == null) {
            System.out.println("El cliente no fue encontrado");
        }
        return clienteBusqueda;
    }

    private static List<Cliente> agregarCliente(List<Cliente> clientes, Scanner scanner) {
        System.out.println("Cual es el nombre del cliente nuevo?");
        scanner.nextLine();
        String nombreNuevo = scanner.nextLine();
        System.out.println("Y el apellido?");
        String apellidoNuevo = scanner.next();
        System.out.println("Finalmente, cual es el dni?");
        scanner.nextLine();
        String dniNuevo = scanner.nextLine();
        clientes.add(new Cliente(dniNuevo, nombreNuevo, apellidoNuevo));
        return clientes;
    }

}