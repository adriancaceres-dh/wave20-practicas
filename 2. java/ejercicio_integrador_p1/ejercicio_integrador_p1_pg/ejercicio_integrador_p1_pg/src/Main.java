import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //List<Client> clientes = new ArrayList<Client>();
        ClientRepository clientRepository = new ClientRepository();
        Scanner scanner = new Scanner(System.in);

        Client client = new Client("39891852", "Luciano", "Benavides");
        Client client1 = new Client("654365437", "Alberto", "Juarez");
        Client client2 = new Client("12342145", "Juan", "Perez");


        //clientRepository.clientes.remove(1);
        /*
        System.out.println("search by dni");
        String dni = scanner.nextLine();
        Client clientByDni = Logic.searchClientByDni(dni, clientRepository);
        System.out.println(clientByDni);
         */
    }
}