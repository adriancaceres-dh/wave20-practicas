package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.model.Deporte;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeporteService {

    List<Deporte> deportes;

    public DeporteService() {
        deportes = new ArrayList<>();
        deportes.add(new Deporte("Baloncesto", "amateur"));
        deportes.add(new Deporte("Beisbol", "profesional"));
        deportes.add(new Deporte("Balonmano", "amateur"));
        deportes.add(new Deporte("Fútbol", "profesional"));
    }

    public List<Deporte> devolverTodosDeportes() {
        return deportes;
    }

    public ResponseEntity<String> devolverDeportePorNombre(String nombreDeporte) {
        Deporte deporte = deportes.stream().filter(d -> d.getNombre().equalsIgnoreCase(nombreDeporte)).findFirst().orElse(null);
        if (deporte != null) {
            return new ResponseEntity<>(deporte.getNivel(), HttpStatus.OK);
        }
        return new ResponseEntity<>("No existe el deporte ingresado.", HttpStatus.BAD_REQUEST);
    }
}
