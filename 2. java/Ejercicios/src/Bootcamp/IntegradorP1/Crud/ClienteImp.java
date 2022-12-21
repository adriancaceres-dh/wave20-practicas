package Bootcamp.IntegradorP1.Crud;


import Bootcamp.IntegradorP1.Tienda.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements Crud <Cliente>{

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public void guardar(Cliente objeto) {
        clientes.add(objeto);

    }

    @Override
    public void mostrar() {
        System.out.println("Clientes: ");
        clientes.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(Integer buscar) {
        boolean buscado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(buscar)) {
                System.out.println(cliente.toString());
                buscado = true;
                return Optional.of(cliente);
            }
        }
        if (buscado== false) {
            System.out.println("Cliente no encontrado");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Integer borrado) {
        Optional<Cliente> c = this.buscar(borrado);
        if (c.isEmpty()) {
            System.out.println("Cliente no encontrado");
        }else{
            clientes.remove(c);
            System.out.println("Cliente eliminado");
        }
    }

    @Override
    public List<Cliente> traer() {
        return clientes;
    }
}
