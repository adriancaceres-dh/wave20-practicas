package com.bootcamp.repository;

import com.bootcamp.model.Cliente;

import java.util.*;

    public class ClienteImp implements CRUDRepository<Cliente>{
        List<Cliente> clientela = new ArrayList<Cliente>();
        @Override
        public void save(Cliente objeto) {
           clientela.add(objeto);
        }

        @Override
        public void mostrarPantalla() {
            clientela.stream()
                    .forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(Integer idBuscar) {
        boolean bandera = false;
        for(Cliente cli : clientela){
            if(cli.getDni().equals(idBuscar)){
                System.out.println("--Cliente encontrado :)--");
                System.out.println(cli);
                return Optional.of(cli);
            }
        }
        if(bandera == false){
            System.out.println("No se enconctó al cliente buscado :(");
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Integer idBorrar) {
        Optional<Cliente> cliente = this.buscar(idBorrar);
        if(cliente.isEmpty()) {
            System.out.println(" No se encontró el cliente a borrar :(");
        }
        else{
            System.out.println("Cliente eliminado :)");
            clientela.remove(cliente.get());
        }
    }
    @Override
    public List<Cliente> traerTodos() {
        return clientela;
    }
}
