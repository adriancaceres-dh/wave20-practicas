package com.bootcamp.claseDos.service;

import com.bootcamp.claseDos.model.Personaje;

import java.util.*;

public class PersonajesService {

    private Map<String, List<Personaje>> personajes;

    public PersonajesService(){
        personajes = new HashMap<>();

        List<Personaje> grupo1 = new ArrayList<>();
        grupo1.add(new Personaje("El grinch","Disney"));
        grupo1.add(new Personaje("Mickey","Disney"));
        personajes.put("Disney",grupo1);

        List<Personaje> grupo2 = new ArrayList<>();
        grupo2.add(new Personaje("Coyote","Acme"));
        grupo2.add(new Personaje("Correcaminos","Acme"));
        personajes.put("Acme",grupo2);

    }

    public List<Personaje> todos(){
        List<Personaje> per = new ArrayList<>();
        personajes.forEach((k,v) -> per.addAll(v));
        return per;
    }

    public List<Personaje> porEmpresa(String empresa){
        return personajes.get(empresa);
    }

    public boolean agregar(Personaje personaje){
        if(!personajes.containsKey(personaje.getEmpresa())) return false;
        personajes.get(personaje.getEmpresa()).add(personaje);
        return true;
    }
}
