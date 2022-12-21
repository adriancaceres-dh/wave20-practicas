package repositorios;

import repositorios.DAO;
import repositorios.RepositorioClientes;

import java.util.ArrayList;

public class FactoryRepositorioClientes {
    private static RepositorioClientes repositorioClientes = null;

    public static RepositorioClientes get() {
        if (repositorioClientes == null) {
            repositorioClientes = new RepositorioClientes(new DAO<>(new ArrayList<>()));
        }
        return repositorioClientes;
    }
}
