package com.example.deportistas.service;

import com.example.deportistas.model.Deporte;

import java.util.*;
import java.util.stream.Collectors;

public class DeporteService {
    private final Set<Deporte> deportes;

    public DeporteService() {
        deportes = new HashSet<>(Arrays.asList(
                new Deporte("futbol", 3),
                new Deporte("basquetbol", 2),
                new Deporte("tenis", 2),
                new Deporte("box", 3),
                new Deporte("golf", 2)
        ));
    }

    public List<Deporte> obtenerDeportes() {
        return new ArrayList<>(deportes);
    }

    public Optional<Deporte> getDeporte(String nombreDeporte) {
        return deportes.stream().filter(deporte -> nombreDeporte.equals(deporte.getNombre())).findFirst();
    }
}
