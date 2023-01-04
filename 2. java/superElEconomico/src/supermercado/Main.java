package supermercado;

import supermercado.model.Cliente;
import supermercado.model.Factura;
import supermercado.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //comprueba si el cliente está en la lista de cliente del Supermercado, si no está, es agregado
    public static void comprobarCliente(Factura f, ArrayList<Cliente> cls){
        if (!cls.contains(f.getCliente())){
            cls.add(f.getCliente());
            System.out.println("------- Nuevo listado de clientes-------");
            for (Cliente c : cls) {
                System.out.println(c);
            }
        }
    }
    public static void main(String[] args) {
        //------------------ EJERCICIOS INTEGRADORES JAVA PARTE 1 ------------------
        Cliente cli1 = new Cliente("12345678", "Lionel", "Messi");
        Cliente cli2 = new Cliente("12345679", "Angel", "Di Maria");
        Cliente cli3 = new Cliente("12345670", "Nicolás", "Otamendi");

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cli1);
        clientes.add(cli2);
        clientes.add(cli3);

        System.out.println("\n----------Listado de Clientes----------");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println("\n----------Listado de Clientes después de borrar 1 cliente----------");
        clientes.remove(cli2);
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println("\n----------Buscador de Clientes por DNI----------");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el DNI del cliente a buscar: ");
        String dni = teclado.nextLine();
        boolean existCli = false;
        for (Cliente c : clientes) {
            if (dni.equals(c.getDni())){
                System.out.println(c);
                existCli = true;
            }
        }
        if(!existCli) System.out.println("No existe el cliente que está buscando\n");

        //------------------ EJERCICIOS INTEGRADORES JAVA PARTE 2 ------------------
        Item item1 = new Item("1", "Café", 2,249.99);
        Item item2 = new Item("2", "Rollo de cocina", 3,500.0);
        Item item3 = new Item("3", "Lata de atún", 4,400.5);
        Item item4 = new Item("4", "Pan lactal", 1,300.0);
        List<Item> compras = new ArrayList<>();
        compras.add(item1);
        compras.add(item4);

        List<Item> compras2 = new ArrayList<>();
        compras2.add(item2);
        compras2.add(item3);

        Factura factura = new Factura(cli1, compras);
        Factura factura2 = new Factura(cli2, compras2);

        comprobarCliente(factura,clientes);
        comprobarCliente(factura2,clientes);

        List<Factura> facturasSuper = new ArrayList<>();
        facturasSuper.add(factura);
        facturasSuper.add(factura2);

        System.out.println("--------Listado de facturas del Supermercado--------");
        for (Factura f : facturasSuper){
            System.out.println(f);
        }
    }
}
