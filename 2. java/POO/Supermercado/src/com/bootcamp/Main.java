package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    int opcion, id;
    String nombre, apellido, dni=null;
    List<Cliente> clientes = new ArrayList<>();

    Scanner teclado = new Scanner(System.in);
    public void menu() {

        do {
            System.out.println("-----------------------------\n" +
                    "Supermercado 'El Económico'\n" +
                    " Por favor, seleccione una opción: \n" +
                    "1-> Ver lista de clientes\n" +
                    "2-> Registrar cliente\n" +
                    "3-> Eliminar cliente\n" +
                    "0-> Salir\n");

            opcion = teclado.nextInt();
            switch (opcion) {
                case 1: {
                    mostrarClientes();
                    break;
                }

                case 2: {
                    agregarCliente(nombre, apellido, dni);
                    break;
                }

                case 3: {
                    eliminarCliente(id);
                    break;
                }

                case 4: {
                    buscarPorDni(dni);
                    break;
                }
            }
        } while(opcion !=0);
    }

    public void agregarCliente(String nombre1, String apellido1, String dni1) {
        System.out.println("Nombre: ");
        nombre1 = teclado.next();
        System.out.println("Apellido: ");
        apellido1 = teclado.next();
        System.out.println("DNI: ");
        dni1 = teclado.next();

        clientes.add(new Cliente(nombre1, apellido1, dni1));

        System.out.println("Usuario registrado con éxito");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Nombre:" + clientes.get(i).getNombre()
                    + ", Apellido:" + clientes.get(i).getApellido() + ", DNI:" + clientes.get(i).getDni());
        }
    }

    public void eliminarCliente(int id1) {
        if(clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
        } else {
            try{
                System.out.println("Ingrese el id del cliente que desea eliminar: ");
                id1 = teclado.nextInt();
                clientes.remove(id1);
                System.out.println("Cliente eliminado con éxito");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("El id ingresado no es válido");
            }
         }

    }

    public void mostrarClientes() {
        if(clientes.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        } else {
            System.out.println("\nLista de clientes: ");
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println("Nombre:" + clientes.get(i).getNombre()
                        + ", Apellido:" + clientes.get(i).getApellido() + ", DNI:" + clientes.get(i).getDni());
            }
        }
    }

    public void buscarPorDni(String dni1) {
        if(clientes.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        } else {
            System.out.println("Ingrese el dni del cliente que desea buscar: ");
            dni1=teclado.next();
            String finalDni = dni1;
            clientes.stream()
                    .parallel()
                    .filter(x->x.getDni().equals(finalDni))
                    .forEach(x-> System.out.println());

        }

    }
    public static void main(String[] args) {

     new Main().menu();
    }
}