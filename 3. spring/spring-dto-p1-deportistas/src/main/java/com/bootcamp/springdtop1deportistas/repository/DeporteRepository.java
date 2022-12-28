package com.bootcamp.springdtop1deportistas.repository;

import com.bootcamp.springdtop1deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DeporteRepository implements IRepository<Deporte> {
    private List<Deporte> deportes;

    public DeporteRepository() {
        deportes = new ArrayList<>();
    }

    public List<Deporte> filterByName(String name) {
        return deportes.stream().filter(d -> d.getNombre().toLowerCase()
                .matches("^.*" + name.toLowerCase() + ".*$"))
                .collect(Collectors.toList());
    }

    public boolean contains(Deporte deporte) {
        List<Deporte> deportePorNombreYNivel = deportes.stream()
                .filter(d -> d.getNombre().equalsIgnoreCase(deporte.getNombre()) &&
                        d.getNivel().equals(deporte.getNivel()))
                .collect(Collectors.toList());
        return deportePorNombreYNivel.size() > 0;
    }

    public boolean add(Deporte deporte) {
        if (contains(deporte)) return false;
        return deportes.add(deporte);
    }
}
