import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("123", "Snoop", "Dogg");
        Cliente c2 = new Cliente("234", "Pepe", "Platano");
        Cliente c3 = new Cliente("345", "Michael", "Scotch");

        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);

        Item i1 = new Item(123L, "Galletas Navideñas", 1, 990);
        Item i2 = new Item(234L, "Shampoo Tio Nacho", 1, 5990);
        Item i3 = new Item(345L, "Acondicionador Tio Nacho", 1, 5990);
        Item i4 = new Item(456L, "Monster Energy Drink", 6, 1350);
        Item i5 = new Item(567L, "Banana", 7, 350);
        Item i6 = new Item(678L, "Lecha Chocolatada", 2, 1900);
        Item i7 = new Item(789L, "Desodorante Nivea", 4, 1550);

        List<Item> listaItems1 = new ArrayList<>();
        listaItems1.add(i1);
        listaItems1.add(i6);
        List<Item> listaItems2 = new ArrayList<>();
        listaItems2.add(i2);
        listaItems2.add(i3);
        listaItems2.add(i7);
        listaItems2.add(i4);
        List<Item> listaItems3 = new ArrayList<>();
        listaItems3.add(i5);
        listaItems3.add(i1);
        listaItems3.add(i4);



        Factura f1 = new Factura(321L, c1, listaItems1);
        System.out.println(f1.toString());

        List<Factura> listaFacturas = new ArrayList<>();


        for(Cliente c : listaClientes){
            System.out.println("Dni: " + c.getDni() + " Nombre: " + c.getNombre() + " " + c.getApellido());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese dni del cliente a borrar");
        String dniBorrado = scanner.next();
        boolean flag = false;

        for(Cliente c : listaClientes) {
            if(c.getDni().equals(dniBorrado)) {
                listaClientes.remove(c);
                flag = true;
                break;
            }
        }
        if(!flag) {
            System.out.println("No se encontro el cliente a borrar");
        }
        else {
            System.out.println("Cliente borrado correctamente");
        }

        System.out.println("Ingrese el dni del cliente a buscar");
        String dniBuscado = scanner.next();

        flag = false;
        for(Cliente c : listaClientes) {
            if(c.getDni().equals(dniBuscado)) {
                System.out.println("--- Cliente encontrado, sus datos son: ---");
                System.out.println("Dni: " + c.getDni() + " Nombre: " + c.getNombre() + " " + c.getApellido());
                flag = true;
                break;
            }
        }

        if(!flag) {
            System.out.println("Cliente no encontrado");
        }
    }
}