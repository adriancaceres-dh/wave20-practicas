package com.bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Clienteimp implements CRUD<Cliente>{

    private List<Cliente> clientes=new ArrayList<>();
    @Override
    public void guardar(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        clientes.stream().forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(String id) {
        Optional<Cliente> resultadoBusqueda=clientes.stream().filter(x->x.getDni().equals(id)).findFirst();
        if (!resultadoBusqueda.isEmpty()) System.out.println(resultadoBusqueda.get());
        else System.out.println("Cliente no encontrado");
        return resultadoBusqueda;

    }

    @Override
    public void eliminar(String id) {
        Optional<Cliente> resultadoBusqueda=buscar(id);
        if(!resultadoBusqueda.isEmpty()){
            clientes.remove(resultadoBusqueda.get());
            mostrarPantalla();
        }

    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }
}
