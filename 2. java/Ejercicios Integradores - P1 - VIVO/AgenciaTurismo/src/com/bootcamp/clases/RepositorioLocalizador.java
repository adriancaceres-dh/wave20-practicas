package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {

    List<Localizador> localizadores;

    public RepositorioLocalizador() {
        localizadores = new ArrayList<>();
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public int adicionarLocalizador(Localizador localizador){
        localizadores.add(localizador);
        System.out.println(localizador);
        return localizadores.size();
    }
}
