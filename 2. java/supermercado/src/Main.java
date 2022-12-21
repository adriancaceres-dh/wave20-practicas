import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Factura> facturas = new ArrayList<>();

    private static boolean buscar(List<Cliente> clientes){
        System.out.print("Ingresar DNI: ");
        String dni = scanner.nextLine();

        for (Cliente cliente: clientes){
            if(cliente.getDni().equals(dni)){
                System.out.println(cliente.toString());
                return true;
            }
        }

        System.out.println("No se ha encontrado ningún cliente");
        return false;
    }

    public static boolean buscar(Cliente cliente){
        for(Cliente cli: clientes) if(cli.equals(cliente)) return true;
        return false;
    }

    public static void agregarFactura(Factura factura){
        if(!buscar(factura.getCliente())) clientes.add(factura.getCliente());
        facturas.add(factura);
    }

    public static void mostrarClientes(){
        for(Cliente cliente: clientes) System.out.println(cliente.toString());
    }

    public static void main(String[] args) {
        clientes.add(new Cliente("20234234", "María", "Del Valle"));
        clientes.add(new Cliente("30234036", "Juan", "Gomez"));
        clientes.add(new Cliente("27332786", "Ernesto", "Julián"));

        mostrarClientes();

        clientes.remove(1);

        mostrarClientes();

        buscar(clientes);

        //Parte 2
        List<Item> items = new ArrayList<>();
        items.add(new Item("0000", "jamónx100", 1, 120));
        items.add(new Item("0001", "quesox100", 2, 110.9f));
        items.add(new Item("0201", "manteca", 1, 88.95f));
        items.add(new Item("0202", "casancrem", 1, 138.75f));
        items.add(new Item("0301", "desodorante", 3, 98.98f));

        Cliente cliente = new Cliente("27337879", "Francisco", "Tapia");
        Factura factura = new Factura(cliente, items);

        agregarFactura(factura);
        mostrarClientes();

    }
}