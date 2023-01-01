package com.bootcamp.Covid_19.repository;
import com.bootcamp.Covid_19.models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonaRepository {

    SintomaRepository sintomaRepository;
    List<Persona> listaPersonas;
    public PersonaRepository(){
        sintomaRepository = new SintomaRepository();

        listaPersonas = new ArrayList<>();

        listaPersonas.add(new Persona("1","Diego","Malagon",23,
                new ArrayList<>(sintomaRepository.getListaDeSintomas().stream().filter(sintoma -> sintoma.getNombre().equals("Tos")
                        || sintoma.getNombre().equals("Fiebre")).collect(Collectors.toList()))));
        listaPersonas.add(new Persona("2","Maria","Malagon",56,
                new ArrayList<>(sintomaRepository.getListaDeSintomas().stream().filter(sintoma -> sintoma.getNombre().equals("Tos")).collect(Collectors.toList()))));
        listaPersonas.add(new Persona("3","Zully","Quevedo",61,
                new ArrayList<>(sintomaRepository.getListaDeSintomas().stream().filter(sintoma -> sintoma.getNombre().equals("Tos")
                        || sintoma.getNombre().equals("Debilidad muscular")).collect(Collectors.toList()))));
        listaPersonas.add(new Persona("4","Ruben","Galindo",73,
                new ArrayList<>(sintomaRepository.getListaDeSintomas().stream().filter(sintoma -> sintoma.getNombre().equals("Tos")
                        || sintoma.getNombre().equals("Fiebre") || sintoma.getNombre().equals("Presion alta")).collect(Collectors.toList()))));

    }
    public List<Persona> getListaPersonas(){
        return listaPersonas;
    }
}
