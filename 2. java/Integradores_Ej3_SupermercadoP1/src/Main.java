import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);

        Cliente cliente0 = new Cliente("123", "Pepito", "Perez");
        Cliente cliente1 = new Cliente("456", "Maria", "Lopez");
        Cliente cliente2 = new Cliente("789", "Juan", "Leon");

        List<Cliente> listaClientes = Arrays.asList(cliente0, cliente1, cliente2);
        Supermercado elEconomico = new Supermercado();


        elEconomico.setClientes(listaClientes);
        String listaMostrable = elEconomico.mostrarClientes();
        System.out.println(listaMostrable);

        System.out.println("Ingresar DNI de cliente a eliminar:");
        String dniEliminar = scannerObj.nextLine();
        elEconomico.eliminarCliente(dniEliminar);

        String listaMostrable1 = elEconomico.mostrarClientes();
        System.out.println(listaMostrable1);

        System.out.println("Ingresar DNI para buscar al cliente:");
        String dni = scannerObj.nextLine();
       Cliente clienteConsultado = elEconomico.mostrarUnCliente(dni);
       if(clienteConsultado.getDni()!= null) System.out.println(clienteConsultado);
       else System.out.println("No hay cliente con ese DNI registrado.");


    }
}