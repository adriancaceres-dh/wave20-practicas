import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente Diego = new Cliente("1019","Diego", "Malagón");
        Cliente Maria = new Cliente("1020","Maria", "Ruiz");
        Cliente Alejandra = new Cliente("1021","Alejandra", "Castro");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(Diego);
        clientes.add(Maria);
        clientes.add(Alejandra);

        for (Cliente c: clientes) {
            System.out.println(c.toString());

        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del usuario a eliminar: \n");
        String dniUser = scanner.nextLine();
        System.out.println(dniUser);

        boolean usuarioEncontrado = false;
        for (Cliente c: clientes) {
            if(c.getDni().equals(dniUser)){
                clientes.remove(c);
                usuarioEncontrado=true;
                break;
            }
        }
        if(usuarioEncontrado==false){
            System.out.println("Cliente no registrado");
        }else{
            System.out.println("Cliente elmininado con exito");
        }

        for (Cliente c: clientes) {
            System.out.println(c.toString());
        }

        usuarioEncontrado=false;
        System.out.println("Ingrese el dni del usuario a buscar: \n");
        dniUser = scanner.nextLine();
        System.out.println(dniUser);

        for (Cliente c: clientes) {
            if(c.getDni().equals(dniUser)){
                System.out.println(c.toString());
                usuarioEncontrado=true;
                break;
            }

        }
        if(usuarioEncontrado==false){
            System.out.println("Usuario no encontrado");
        }
    }

}