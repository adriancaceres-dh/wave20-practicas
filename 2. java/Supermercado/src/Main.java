import com.bootcamp.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cli1 = new Cliente(23623444L, "Raul", "Roberto");
        Cliente cli2 = new Cliente(96822453L, "Milo", "Petardo");
        Cliente cli3 = new Cliente(23411123L, "Laura", "Iorio");

        Supermercado supermercado = new Supermercado();
        supermercado.agregarCliente(cli1);
        supermercado.agregarCliente(cli2);
        supermercado.agregarCliente(cli3);

        supermercado.mostrarClientes();

        supermercado.removerCliente(cli2.getDni());
        System.out.println("Se borró a " + cli2.getNombre());

        supermercado.mostrarClientes();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni a buscar");
        Long dniBuscado = teclado.nextLong();

        boolean encontrado = supermercado.buscarCliente(dniBuscado);

        if (!encontrado) {
            System.out.println("Cliente no encontrado");
        }

        // PARTE 2:
        List<Item> listaItems = new ArrayList<>();
        listaItems.add(new Item(83753L, "Peluche", 1, 450));
        listaItems.add(new Item(24520L, "Leche", 2, 110));
        listaItems.add(new Item(68220L, "Sarten", 1, 1500));

        Cliente cli4 = new Cliente(7802243L, "Matilde", "Logroria");

        Factura factura = new Factura(556466L, cli4, listaItems);

        supermercado.agregarFactura(factura);

        supermercado.mostrarClientes();
    }
}