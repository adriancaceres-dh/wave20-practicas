package com.example.deportistas.services;

import com.example.deportistas.models.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteService {
    private final List<Deporte> deportes = new ArrayList<>();

    public boolean addDeporte(Deporte deporte) {
        deportes.add(deporte);
        return true;
    }

    public List<Deporte> getAllDeportes() {
        return deportes;
    }

    public Deporte getDeporte(String name) {
        return deportes.stream()
                .filter(d -> d.getNombre().equals(name))
                .findAny()
                .orElse(null);
    }
}
