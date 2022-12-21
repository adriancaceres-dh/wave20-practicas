import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Logic {
    public static double calcularTotal(List<Item> items){
        double totalCost = items.stream().mapToDouble(Item::getCosto).sum();
        return totalCost;
    }
    public static Client searchClientByDni(String dni, ClientRepository clientRepository){
        for (Client client : clientRepository.clientes){
            if(client.getDni().equals(dni)) {
                return client;
            }
        }
        throw new Error ("no se encontro el cliente");
    }


}
