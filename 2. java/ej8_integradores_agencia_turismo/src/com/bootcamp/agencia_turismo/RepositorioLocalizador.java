package com.bootcamp.agencia_turismo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioLocalizador {

    private static List<Localizador> listaLocalizadores= new ArrayList<>();

    public static boolean addLocalizador(Localizador localizador){
        listaLocalizadores.add(localizador);
        System.out.println(localizador);
        return true;
    }
}
