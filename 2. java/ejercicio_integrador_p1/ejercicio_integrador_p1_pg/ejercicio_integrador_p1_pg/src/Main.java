import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //List<Client> clientes = new ArrayList<Client>();
        ClientRepository clientRepository = new ClientRepository();

        clientRepository.clientes.add(new Client("39891852", "Luciano", "Benavides"));
        clientRepository.clientes.add(new Client("654365437", "Alberto", "Juarez"));
        clientRepository.clientes.add(new Client("12342145", "Juan", "Perez"));
        //clientRepository.clientes.remove(1);
        for(Client client : clientRepository.clientes) {
            System.out.println(client.toString());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("search by dni");
        String dni = scanner.nextLine();
        Logic.searchClientByDni(dni, clientRepository);


    }
}