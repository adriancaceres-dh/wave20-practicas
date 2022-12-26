package com.example.persona.services;

import com.example.persona.model.Deporte;
import com.example.persona.model.dtos.DeporteDto;
import com.example.persona.model.dtos.PersonaConDeporteDto;
import com.example.persona.repositories.DeporteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeporteService {

    private static DeporteRepository _repo = new DeporteRepository();
    public List<DeporteDto> ObtenerDeportes(){

        return _repo.getDeportes().stream().map(deporte -> new DeporteDto(deporte.getNombre(), deporte.getNivel())).toList();
    }
    public List<String> ObtenerNombresDeportes(){

        return _repo.getDeportes().stream().map(deporte -> deporte.getNombre()).toList();
    }

    public String ObtenerNivelDeDeporteByNombre(String Nombre){

          Optional<Deporte> deporteSeleccionado =_repo.getDeportes().stream().filter(deporte -> deporte.getNombre().toLowerCase().equals(Nombre.toLowerCase())).findFirst();

          if (deporteSeleccionado.isPresent())
              return deporteSeleccionado.get().getNivel().name();
          return null;
    }
    public Optional<Deporte> ObtenerDeporteById(int id){

        return _repo.getDeporteById(id);
    }

}
