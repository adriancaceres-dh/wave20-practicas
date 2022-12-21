package Clases;

import java.util.HashSet;
import java.util.Set;

public class RepositorioClientes {
    private Set<Cliente> clientes;


    public boolean agregarClienteARepositorio(Cliente cliente){
        return clientes.add(cliente);
    }


    public RepositorioClientes() {
        this.clientes = new HashSet<>();
    }
}
