package com.company;

import com.company.model.Cliente;
import com.company.model.Item;
import com.company.model.Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //creamos 3 clientes
        Cliente cli1 = new Cliente(12365458L, "Luisina", "de Paula");
        Cliente cli2 = new Cliente(65987456L, "Zlatan", "Ibrahimovic");
        Cliente cli3 = new Cliente(11254789L, "Avril", "Lavigne");
        //agregamos a una collection
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3);

        //mostrando todos los clientes
        for (Cliente c : listaClientes) {
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
            System.out.println("-----------------------------");
        }

        List<Item> listaItems = new ArrayList<Item>();
        listaItems.add(new Item("Bananas", 5, 10));
        listaItems.add(new Item("Manzanas", 2, 10));
        listaItems.add(new Item("Pomelo", 5, 3));


        Supermercado.emitirFactura(cli1,listaItems);

        /*//borrado del cliente
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a borrar");
        Long dniBorrado = teclado.nextLong();
        boolean bandera = false;

        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBorrado)) {
                listaClientes.remove(c);
                bandera = true;
                break;
            }
        }
        if (bandera == false) {
            System.out.println("No se encontró el cliente a borrar");
        }
        else {
            System.out.println("Cliente borrado correctamente");
        }

        //buscar cliente en particular
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();

        bandera = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("----Cliente encontrado, sus datos son: ----");
                System.out.println("Dni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                break;
            }
        }

        if (bandera == false) {
            System.out.println("Cliente no encontrado");
        }*/

    }
}
