package EjercicioIntegradorP1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(252525,"Juan","Perez");
        Cliente cliente2 = new Cliente(253456,"Franco","Tom");
        Cliente cliente3 =new Cliente(123455,"Reinal","Wall");
        List<Cliente>clienteList = new ArrayList<>();
        clienteList.add(cliente1);
        clienteList.add(cliente2);
        clienteList.add(cliente3);

        Item producto1 = new Item(2435,"Coca-Cola",500.50);
        Item producto2 = new Item(2235,"Agua",150.15);
        Item producto3 = new Item(2135,"Pan",250.33);
        List<Item> itemList = new ArrayList<>();
        itemList.add(producto1);
        itemList.add(producto2);
        itemList.add(producto3);

        double totalFactura = Factura.totalFactura(itemList);
        Factura factura1 = new Factura(3021,cliente1,itemList,totalFactura);

        /*System.out.println("Eliminar uno de los clientes de la lista y volver a consultar e imprimir todos los clientes restantes");
        Cliente.removerCliente(clienteList,cliente1);
        System.out.println("----------------------------------");
        System.out.println("Solicitar por teclado un número de dni de un cliente para buscarlo");
        Scanner sc = new Scanner(System.in);
        int dniCliente = sc.nextInt();
        Cliente.buscarCliente(clienteList,dniCliente);*/











    }
}
