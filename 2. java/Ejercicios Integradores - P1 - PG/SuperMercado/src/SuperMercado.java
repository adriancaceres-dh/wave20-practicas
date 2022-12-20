import com.bootcamp.clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SuperMercado {

    public static void main(String[] args) {
        List<Cliente> listaCliente = new ArrayList<>();
        Cliente cliente1 = new Cliente("1478526-4", "Juan", "López");
        Cliente cliente2 = new Cliente("2547896-1", "Raúl", "Rodríguez");
        Cliente cliente3 = new Cliente("4587126-2", "José", "Pérez");
        listaCliente.add(cliente1);
        listaCliente.add(cliente2);
        listaCliente.add(cliente3);
        for (Cliente c : listaCliente) {
            System.out.println(c);
        }
        System.out.println("-----------Eliminar 1 cliente------------");
        listaCliente.remove(1);
        for (Cliente c : listaCliente) {
            System.out.println(c);
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Entre el DNI del cliente");
            System.out.println("Ingrese 'exit' para salir");
            String dni = scanner.next();
            if (dni.equalsIgnoreCase("exit")) break;
            List<Cliente> clienteEncontrados = listaCliente.stream().filter(x -> x.getDni().equalsIgnoreCase(dni)).collect(Collectors.toList());
            if (clienteEncontrados.size() == 0){
                System.out.println("El DNI ingresado no coicide con ninguno del listado de clientes.");
            }else {
                clienteEncontrados.forEach(System.out::println);
            }

        }

    }

}
