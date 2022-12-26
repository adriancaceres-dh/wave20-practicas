import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientImp implements ICrud<Cliente>{

    List<Cliente> listaClientes = new ArrayList<>();
    @Override
    public void create(Cliente item) {
        listaClientes.add(item);
    }

    @Override
    public List<Cliente> read() {
        System.out.println(listaClientes);
        return listaClientes;
    }

    @Override
    public Optional<Cliente> find(String id) {
        System.out.println(listaClientes.stream().filter(x -> x.getDni().equals(id)).findFirst());
        return listaClientes.stream().filter(x -> x.getDni().equals(id)).findFirst();
    }

    @Override
    public void update(Cliente item) {

    }

    @Override
    public void delete(String id) {
        listaClientes.removeIf(x -> x.getDni().equals(id));
    }
}
