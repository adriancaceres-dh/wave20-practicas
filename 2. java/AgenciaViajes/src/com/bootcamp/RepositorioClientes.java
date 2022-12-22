package com.bootcamp;

import java.util.HashSet;
import java.util.Set;

public class RepositorioClientes {

    Set<Cliente> repositorio;

    public RepositorioClientes() {
        repositorio = new HashSet<>();
    }

    public Set<Cliente> getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Set<Cliente> repositorio) {
        this.repositorio = repositorio;
    }


}
