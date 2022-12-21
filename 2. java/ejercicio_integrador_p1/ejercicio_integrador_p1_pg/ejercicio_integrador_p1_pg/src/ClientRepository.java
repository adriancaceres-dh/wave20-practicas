import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    protected List<Client> clientes;

    public ClientRepository() {
        this.clientes = new ArrayList<Client>();
    }

    public  Client createClient(Client client){
        for (Client client1 : clientes) {
            if (client1.getDni().equals(client.getDni()))return client;
        }
        clientes.add(client);
        return client;
    }

    @Override
    public String toString() {
        return "ClientRepository{" +
                "clientes=" + clientes.toString() +
                '}';
    }
}
