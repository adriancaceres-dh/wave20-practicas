package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Supermercado {
    private List<Cliente> clientes;
    private List<Factura> facturas;

    public Supermercado(){
        clientes = new ArrayList<>();
        facturas = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void imprimirClientes(){
        clientes.stream().forEach(c -> System.out.println(c));
    }

    public void eliminarCliente(String dni){
        Optional<Cliente> clienteABorrar = clientes.stream().filter(c -> c.getDni().equals(dni)).findFirst();
        if(clienteABorrar.isPresent()){
            System.out.println("Borrando -> " + clienteABorrar.get());
            clientes.remove(clienteABorrar.get());
        }else{
            System.out.println("No hay un cliente con ese dni");
        }
    }

    public void mostrarCliente(String dni){
        Optional<Cliente> clienteAMostrar = clientes.stream().filter(c -> c.getDni().equals(dni)).findFirst();
        if(clienteAMostrar.isPresent()){
            System.out.println(clienteAMostrar.get());
        }else{
            System.out.println("No hay un cliente con ese dni");
        }
    }
}
