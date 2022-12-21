package Bootcamp.IntegradorP1.Tienda;

import Bootcamp.IntegradorP1.Crud.ClienteImp;
import Bootcamp.IntegradorP1.Crud.FacturaImp;
import Bootcamp.IntegradorP1.Crud.ItemImp;
import Bootcamp.IntegradorP1.Tienda.Cliente;
import Bootcamp.IntegradorP1.Tienda.Factura;
import Bootcamp.IntegradorP1.Tienda.Item;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ClienteImp clienteImp = new ClienteImp();
        FacturaImp facturaImp = new FacturaImp();
        ItemImp itemImp = new ItemImp();

        // Crear clientes
        Cliente cliente1= new Cliente(1923, "Carlos", "Escobar");
        Cliente cliente2 = new Cliente(1421, "Alejandro", "Torres");
        Cliente cliente3 = new  Cliente(1453, "Pablo", "Picapiedras");

        //Crear items
        Item items1 = new Item(2, "papas", 12, 1400.0);
        Item items2 = new Item(3, "frijoles", 8, 400.0);
        Item items3 = new Item(4, "lentejas", 13, 540.0);

        // Gurdar items
        itemImp.guardar(items1);
        itemImp.guardar(items2);
        itemImp.guardar(items3);

        // Mostrar items
        itemImp.mostrar();

        // Guardar clientes
        clienteImp.guardar(cliente1);
        clienteImp.guardar(cliente2);
        clienteImp.guardar(cliente3);

        // Mostrar clientes
        clienteImp.mostrar();

        //Buscar clientes
        System.out.println("Ingrese el dni del cliente que desea buscar: ");
        int dni_buscado = scan.nextInt();
        clienteImp.buscar(dni_buscado);

        // Eliminar clientes
        System.out.println("Ingrese el dni del cliente que desea eliminar: ");
        int cliente_borrado = scan.nextInt();
        clienteImp.eliminar(cliente_borrado);


            /*System.out.println("Elija una opcion: ");
            System.out.println("1. Mostrar los clientes: ");
            System.out.println("2. Eliminar un cliente: ");
            System.out.println("3. Buscar un cliente por su dni: ");
            System.out.println("4. Salir ");*/
    }
}
