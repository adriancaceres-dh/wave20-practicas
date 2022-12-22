package com.supermercado_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(34567876L, "karen", "Hoffman"));
        clientes.add(new Cliente(35567876L, "Roberto", "Perez"));
        clientes.add(new Cliente(36567876L, "Blanca", "Gomez"));

        //FALTA VALIDACION DE DATOS INGRESADOS POR EL USUARIO.


        System.out.println("Ingrese el dni del cliente que desea eliminar");
        Long dniEliminar = input.nextLong();
        boolean aux = false;
        Cliente clienteEliminar = null;
        for (Cliente cliente : clientes) {
            if (dniEliminar.equals(cliente.getDni())) {
                clienteEliminar = cliente;
                aux = true;
            }

        }
        if (aux) {
            clientes.remove(clienteEliminar);
            System.out.println("El cliente: "+"DNI: "+ clienteEliminar.getDni() + " Nombre: "+ clienteEliminar.getNombre() +
                    " Apellido: "+ clienteEliminar.getApellido()+ " ha sio eliminado de la lista.");
        } else {
            System.out.println("No se encontró un cliente con ese dni registrado.");
        }


        System.out.println("Datos de los/las clientes");
        for (Cliente cliente : clientes) {
            System.out.println("DNI: "+ cliente.getDni() + " Nombre: "+ cliente.getNombre() +
                    " Apellido: "+ cliente.getApellido());

        }

        System.out.println("Ingrese el dni del cliente que desea encontrar");
        Long dni = input.nextLong();
        boolean bandera = false;
        for (Cliente cliente : clientes) {
            if (dni.equals(cliente.getDni())) {
                System.out.println("DNI: "+ cliente.getDni() + " Nombre: "+ cliente.getNombre() +
                        " Apellido: "+ cliente.getApellido());
                bandera = true;
            }

        }
        if (bandera == false) System.out.println("No se encontró un cliente con ese dni registrado.");

    }
}
