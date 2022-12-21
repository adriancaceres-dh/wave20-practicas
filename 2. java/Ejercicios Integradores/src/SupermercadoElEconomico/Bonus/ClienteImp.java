package SupermercadoElEconomico.Bonus;

import SupermercadoElEconomico.CRUD;
import SupermercadoElEconomico.Cliente;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClienteImp implements CRUD<Cliente> {

    LinkedList<Cliente> clientes = new LinkedList<>();
    @Override
    public boolean alta(Cliente cliente) {
        if(clientes.contains(cliente)){
            return false;
        }
        clientes.add(cliente);
        return true;
    }

    @Override
    public boolean baja(Integer id) {
        Cliente eliminar = null;
        // Esto se mejoraria con un MAP<dniCliente, Cliente>.
        List<Cliente> clienteEliminar = clientes.stream().filter(x->x.getDni()==id).collect(Collectors.toList());
        if(!clienteEliminar.isEmpty()){
            eliminar = clienteEliminar.get(0);
            return clientes.remove(eliminar); // Se supone que debería dar true
        }else{
            return false;
        }
    }

    @Override
    public Optional<Cliente> buscar(Integer dniCliente) {
        Cliente encontrado = null;
        // Esto se mejoraria con un MAP<dniCliente, Cliente>.
        List<Cliente> clienteBuscar = clientes.stream().filter(x->x.getDni()==dniCliente).collect(Collectors.toList());
        if(!clienteBuscar.isEmpty()){
            encontrado = clienteBuscar.get(0);
            return encontrado;
        }else{
            return false;
        }
    }

    @Override
    public void mostrarEnPantalla(Cliente cliente) {

    }

    @Override
    public List<Cliente> traerTdos(Cliente cliente) {
        return null;
    }
}
