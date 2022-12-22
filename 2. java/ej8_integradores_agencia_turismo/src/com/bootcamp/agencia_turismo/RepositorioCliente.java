package com.bootcamp.agencia_turismo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {

    private static List<Cliente> listaClientes= new ArrayList<>();

    public static Cliente buscarCliente(String dni){
        return listaClientes.stream()
                .filter(lista->lista.getDni()
                .equals(dni))
                .findFirst()
                .get();
    }

    public static boolean addCliente(Cliente cliente){
        listaClientes.add(cliente);
        return true;
    }
}
