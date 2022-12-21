import SupermercadoElEconomico.Cliente;
import SupermercadoElEconomico.Factura;
import SupermercadoElEconomico.Item;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("########### EJERCICIO DEL SUPERMERCADO ´EL ECONÓMICO´ ###########\n");

        System.out.println("########### PARTE I ########### ");
        Cliente C1 = new Cliente(51907552, "Emanuel", "Fonseca");
        Cliente C2 = new Cliente(51907553, "Adrián", "Cáceres");
        Cliente C3 = new Cliente(51907552, "Luis", "Suárez");

        LinkedList<Cliente> clientes = new LinkedList<>();
        clientes.add(C1);
        clientes.add(C2);
        clientes.add(C3);

        clientes.forEach(System.out::println);
        System.out.println();
        clientes.remove(C1);
        clientes.forEach(System.out::println);
        System.out.println();

        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese CI de la persona a buscar: ");
        try {
            int ciBuscar = Integer.parseInt(lectura.next());
            List<Cliente> encontrado = clientes.stream().filter(x -> x.getDni() == ciBuscar).collect(Collectors.toList());
            if (encontrado.isEmpty()) {
                System.out.println("El usuario no existe.");
            } else {
                System.out.println(encontrado.remove(0));
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("\n########### PARTE II ########### ");
        Factura nuevaFactura = new Factura(123, C1);

        Map<Integer, Factura> facturas = new HashMap<>();
        if (clientes.contains(nuevaFactura.getCliente())) {
            facturas.put(nuevaFactura.getCodigoFactura(), nuevaFactura);
        } else {
            clientes.add(nuevaFactura.getCliente());
        }

        List<Item> productosComprados = new LinkedList<>();
        // Los item deberían ser creados dentro de un método dentro de Item por tema de encapsulación
        // Por simplicidad se hace de esta manera.
        productosComprados.add(new Item("Pro-12", "Camisa", 12.0,3));
        productosComprados.add(new Item("Pro-13", "Cordones", 12.0,3));
        productosComprados.add(new Item("man-13", "Manteca", 2.0,5));
        nuevaFactura.setListaCompra(productosComprados);
        System.out.println("El total de la compra realizada por el usuario: " +
                nuevaFactura.getCliente().toString() + "\nEs de: " + nuevaFactura.calcularTotalCompra());

    }
}