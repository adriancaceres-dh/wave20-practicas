package com.bootcamp;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>(
                Arrays.asList(new Cliente(37550240, "Francisco", "Berthet"),
                        new Cliente(287654300, "Nahuel", "Inventado"),
                        new Cliente(8888888, "Martin", "Trinidad")));


        System.out.println("Clientes");
        clientes.forEach(c ->
                System.out.println("DNI: " + c.dni + ", Nombre: " + c.nombre + ", Apellido: " + c.apellido));

        /* Elimino cliente por DNI
        Se asigna nuevamente ya que el resultado de un stream no muta el objeto original */
        System.out.println("eliminando cliente con DNI 37550240...");
        clientes = clientes.stream()
                .filter(e -> e.dni != 37550240)
                .collect(Collectors.toList());

        System.out.println("Clientes");
        clientes.forEach(c ->
                System.out.println("DNI: " + c.dni + ", Nombre: " + c.nombre + ", Apellido: " + c.apellido));


        Scanner scanner = new Scanner(System.in);

        System.out.println("Busqueda de clientes");


        boolean buscar = true;
        do {
            try {
                System.out.print("Ingrese dni de cliente a buscar: ");
                Integer dni = scanner.nextInt();
                clientes.stream().filter(e ->
                        e.dni.equals(dni)).findFirst().ifPresentOrElse(System.out::println,
                        () -> System.out.println("No se encontro ningun cliente con ese DNI"));

                buscar = false;
            } catch (InputMismatchException e) {
                System.out.println("Formato invalido, por favor ingrese un numero de DNI a buscar");
                scanner.nextLine();
            }
        } while (buscar);
    }





}
