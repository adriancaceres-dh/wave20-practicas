import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente Diego = new Cliente("1019", "Diego", "Malagón");
        Cliente Maria = new Cliente("1020", "Maria", "Ruiz");
        Cliente Alejandra = new Cliente("1021", "Alejandra", "Castro");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(Diego);
        clientes.add(Maria);
        clientes.add(Alejandra);

        for (Cliente c : clientes) {
            System.out.println(c.toString());

        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del usuario a eliminar: \n");
        String dniUser = scanner.nextLine();
        System.out.println(dniUser);

        boolean usuarioEncontrado = false;
        for (Cliente c : clientes) {
            if (c.getDni().equals(dniUser)) {
                clientes.remove(c);
                usuarioEncontrado = true;
                break;
            }
        }
        if (usuarioEncontrado == false) {
            System.out.println("Cliente no registrado");
        } else {
            System.out.println("Cliente elmininado con exito");
        }

        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }

        usuarioEncontrado = false;
        System.out.println("Ingrese el dni del usuario a buscar: \n");
        dniUser = scanner.nextLine();
        System.out.println(dniUser);

        for (Cliente c : clientes) {
            if (c.getDni().equals(dniUser)) {
                System.out.println(c.toString());
                usuarioEncontrado = true;
                break;
            }

        }
        if (usuarioEncontrado == false) {
            System.out.println("Usuario no encontrado");
        }

        List<Item> listadoProductosComprado = new ArrayList<>();
        Item arroz = new Item("0001","Arroz",1,2500);
        Item huevo = new Item("0002","Huevo",1,700);
        listadoProductosComprado.add(arroz);
        listadoProductosComprado.add(huevo);
        List<Factura> litadoFacturas = new ArrayList<>();
        for (Cliente c: clientes) {
            if(c.equals(Diego)){
                Factura fac1 = new Factura(Diego, listadoProductosComprado);
                litadoFacturas.add(fac1);

            }else{
                Diego = new Cliente(Diego.dni, Diego.nombre, Diego.apellido);
                Factura fac1 = new Factura(Diego, listadoProductosComprado);
                litadoFacturas.add(fac1);
            }


        }

    }


}