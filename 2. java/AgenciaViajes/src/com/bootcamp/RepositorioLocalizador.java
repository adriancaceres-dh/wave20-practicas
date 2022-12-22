package com.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {
    private List<Localizador> repositorio;

    public RepositorioLocalizador() {
        repositorio = new ArrayList<>();
    }

    public List<Localizador> getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(List<Localizador> repositorio) {
        this.repositorio = repositorio;
    }
}
