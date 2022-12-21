package com.bootcamp.repositosio;

import com.bootcamp.clases.Cliente;
import com.bootcamp.interfaces.ICRUD;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioCliente implements ICRUD<Cliente> {

    List<Cliente> listaClientes;

    public RepositorioCliente() {
        listaClientes = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    @Override
    public int adicionarElemento(Cliente elemento) {
        if (listaClientes.size() == 0 || !listaClientes.contains(elemento)) {
            listaClientes.add(elemento);
        }
        return listaClientes.size();
    }

    @Override
    public int eliminarElemento(Cliente elemento) {
        listaClientes.remove(elemento);
        return listaClientes.size();
    }

    @Override
    public Cliente obtenerElementoByPos(int pos) {
        return listaClientes.get(pos);
    }

    @Override
    public boolean existeElemento(Cliente elemento) {
        return listaClientes.contains(elemento);
    }


    public List<Cliente> existeCliente(String dni) {
        List<Cliente> clientesEncontradoss = listaClientes.stream().filter(x -> x.getDni().equalsIgnoreCase(dni)).collect(Collectors.toList());
        if (clientesEncontradoss.size() > 0) {
            return clientesEncontradoss;
        }
        return null;
    }
}
