package com.bootcamp.ej_integrador_supermercado;

import java.util.List;

public class Supermercado {

    private List<Cliente> listaClientes;

    public Supermercado(){}

    public void crearCliente(Cliente cliente){
        listaClientes.add(cliente);
    }

    public void consultaClientes(String dni){
        for(Cliente cliente: this.listaClientes){
            if (cliente.getDni().equals(dni)){
                System.out.println(cliente);
                return;
            }
        }
        System.out.println("No se encontro el cliente con el dni "+dni);
    }

    public void eliminacionCliente(Cliente cliente){
        listaClientes.remove(cliente);
    }

    public void actualizacionCliente(){}

    public void mostrarClientes(){
        listaClientes.stream().forEach(System.out::println);
    }
}
