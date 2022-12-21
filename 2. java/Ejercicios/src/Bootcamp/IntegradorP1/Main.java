package Bootcamp.IntegradorP1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1923, "Carlos", "Escobar"));
        clientes.add(new Cliente(1421, "Alejandro", "Torres"));
        clientes.add(new Cliente(1453, "Pablo", "Picapiedras"));

        boolean iniciado = true;

        while(iniciado){
            System.out.println("Elija una opcion: ");
            System.out.println("1. Mostrar los clientes: ");
            System.out.println("2. Eliminar un cliente: ");
            System.out.println("3. Buscar un cliente por su dni: ");
            System.out.println("4. Salir ");
            int opcion = scan.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Clientes: ");
                    clientes.stream().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Ingrese el dni del cliente que desea eliminar: ");
                    int numero = scan.nextInt();
                    boolean eliminado = false;
                    for (Cliente cliente : clientes) {
                        if (cliente.getDni().equals(numero)) {
                            clientes.remove(cliente);
                            System.out.println("Cliente eliminado exitosamente");
                            eliminado = true;
                            break;
                        }
                    }
                    if (eliminado == false) {
                        System.out.println("Cliente no encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el dni del cliente que desea buscar: ");
                    int buscar = scan.nextInt();
                    boolean buscado = false;
                    for (Cliente cliente : clientes) {
                        if (cliente.getDni().equals(buscar)) {
                            System.out.println(cliente.toString());
                            buscado = true;
                            break;
                        }
                    }
                    if (buscado== false) {
                        System.out.println("Cliente no encontrado");
                    }
                    break;
                case 4:
                    iniciado = false;
                    System.out.println("Programa finalizado");
            }
        }
    }
}
