package com.bootcamp;

public class Agencia {

    private RepositorioClientes repoClientes;
    private RepositorioLocalizador repoLocalizador;

    public Agencia() {
        repoClientes = new RepositorioClientes();
        repoLocalizador = new RepositorioLocalizador();
    }

    public RepositorioClientes getRepoClientes() {
        return repoClientes;
    }

    public void setRepoClientes(RepositorioClientes repoClientes) {
        this.repoClientes = repoClientes;
    }

    public RepositorioLocalizador getRepoLocalizador() {
        return repoLocalizador;
    }

    public void setRepoLocalizador(RepositorioLocalizador repoLocalizador) {
        this.repoLocalizador = repoLocalizador;
    }
}
