package com.bootcamp.repasoapi.service;

import com.bootcamp.repasoapi.model.Personaje;

import java.util.*;
import java.util.stream.Collectors;

public class PersonajesService {

    private Map<String, List<Personaje>> personajes;

    public PersonajesService() {

        personajes = new HashMap<>();

        List<Personaje> grupo1 = new ArrayList<>();
        grupo1.add(new Personaje("El grich","Disney"));
        grupo1.add(new Personaje("Mickey","Disney"));
        personajes.put("Disney",grupo1);

        List<Personaje> grupo2 = new ArrayList<>();
        grupo2.add(new Personaje("Coyote","Acme"));
        grupo2.add(new Personaje("Correcaminos","Acme"));
        personajes.put("Acme",grupo2);

    }

    public String agregar(Personaje personaje) {
        if(!personajes.containsKey(personaje.getEmpresa())) {
            return "No agragado";
        }
        personajes.get(personaje.getEmpresa()).add(personaje);
        return "Agregado";
    }

    public List<Personaje> todos(String empresa, String nombre) {
        List<Personaje> per = new ArrayList<>();
        if(empresa == null && nombre == null) {
            List<Personaje> finalPer = per;
            personajes.forEach((k, v) ->  finalPer.addAll(v) );
        } else {
            if ( empresa != null ) {
                per = personajes.get(empresa);
            }
            if ( nombre != null ) {
                per = personajes.get(empresa).stream().filter(p -> p.getNombre().equals(nombre))
                        .collect(Collectors.toList());
            }
        }
        return per;
    }



}
