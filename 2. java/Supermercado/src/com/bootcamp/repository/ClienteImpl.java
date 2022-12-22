package com.bootcamp.repository;

import com.bootcamp.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class ClienteImpl implements Repository<Cliente>, Calculo<Cliente>{
    List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public void guardar(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void eliminar(Long dniBorrar) {
        Optional<Cliente> cliente = this.buscar(dniBorrar);

        if (cliente.isEmpty()){
            System.out.println("No se encontro el Cliente con DNI " + dniBorrar + " para ser borrado");
        }else {
            System.out.println("Se borro el cliente con DNI " + dniBorrar + " para ser borrado");
            listaClientes.remove(cliente.get());
        }
        for (Cliente cli : listaClientes){
            System.out.println(cli);
        }
    }

    @Override
    public void mostrar() {
        for (Cliente cliente : listaClientes){
            System.out.println(cliente);
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscar) {

        boolean confirmacion = false;

        for (Cliente cli : listaClientes) {
            if (cli.getDni().equals(dniBuscar)) {
                System.out.println(cli);
                confirmacion = true;
                return Optional.of(cli);
            }
        }
        if(!confirmacion){
            System.out.println("No se encontro el cliente con DNI " + dniBuscar);
        }

        return Optional.empty();
    }

    @Override
    public List<Cliente> buscarTodos() {
        return listaClientes;
    }

    @Override
    public Double calcular() {
        return null;
    }

    @Override
    public Cliente verificar(Long dni, String nombre, String apellido) {
        boolean bandera = false;
        for (Cliente cli : listaClientes){
            if(cli.getDni() == dni){
                return cli;
            }else {
                bandera = true;
            }
        }
        if(bandera){
            Cliente nuevoCli = new Cliente(dni, nombre, apellido);
            this.guardar(nuevoCli);
            return nuevoCli;
        }
        return new Cliente();
    }
}
