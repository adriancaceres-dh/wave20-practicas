package repositorios;

import supermercado.Cliente;

import java.util.Optional;

public class RepositorioClientes extends RepositorioGenerico<Cliente> {

    protected RepositorioClientes(DAO<Cliente> dao) {
        super(dao);
    }

    public Optional<Cliente> buscarPorDNI(String dni) {
        return this.dao.buscar(cliente -> cliente.getDni().equals(dni));
    }
}
