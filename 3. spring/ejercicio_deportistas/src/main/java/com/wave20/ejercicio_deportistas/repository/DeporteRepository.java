package com.wave20.ejercicio_deportistas.repository;

import com.wave20.ejercicio_deportistas.DTO.DeporteDTO;
import com.wave20.ejercicio_deportistas.model.Deporte;
import com.wave20.ejercicio_deportistas.model.Persona;

import java.util.*;

public class DeporteRepository {

    private static Set<Deporte> deportes = new HashSet<>();


    public Optional<Deporte> agregarDeporte(DeporteDTO deporte) {
        if (deportes.stream().filter(deporte1 -> deporte.getNombre().equals(deporte1.getNombre())).findAny().isPresent()) {
            return Optional.empty();
        } else {
            Deporte d = new Deporte(deporte.getNombre(), deporte.getNivel());
            deportes.add(d);
            return Optional.of(d);
        }

    }

    public Optional<Deporte> eliminarDeporte(String nombre)  {
        Optional<Deporte> deporte = deportes.stream().filter(d -> d.getNombre().equals(nombre)).findAny();
        if (deporte.isPresent()) {
            deportes.remove(deporte.get());
            return Optional.of(deporte.get());
        } else {
            return Optional.empty();
        }
    }


    public Optional<Deporte> getDeporte(String nombre) {
        return deportes.stream().filter(d -> d.getNombre().equals(nombre)).findAny();


    }

    public Set<Deporte> getDeportes() {
        //Se agregan dos deportes de ejemplo para prueba de uso, se deben eliminar luego ya que sino se van a
        //estar intentando agregar en cada llamada.
        deportes.add(new Deporte("Tenis", "medio"));
        deportes.add(new Deporte("Natación", "alto"));
        return deportes;
    }




}

