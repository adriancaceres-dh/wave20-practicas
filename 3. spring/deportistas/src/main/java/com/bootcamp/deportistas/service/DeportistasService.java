package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.response.DeporteResponseDto;
import com.bootcamp.deportistas.dto.response.DeportistaResponseDto;
import com.bootcamp.deportistas.model.Deporte;
import com.bootcamp.deportistas.model.Persona;
import org.springframework.data.util.StreamUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeportistasService {

    List<Persona> personas;
    List<Deporte> deportes;
    public DeportistasService() {
        personas = new ArrayList<>();
        personas.add(new Persona("Roberto","Martinez",25));
        personas.add(new Persona("Ricardo","Romero",21));
        personas.add(new Persona("Sergio","Marquez",28));

        deportes = new ArrayList<>();
        deportes.add(new Deporte("Futbol", "Alto"));
        deportes.add(new Deporte("Beisbol","Bajo"));
        deportes.add(new Deporte("Softbol","Medio"));
    }

    public List<DeporteResponseDto> buscarDeportes() {
        List<DeporteResponseDto> listaSalida = new ArrayList<>();
        deportes
                .stream()
                .forEach(i -> listaSalida.add(new DeporteResponseDto(i.getNombre(),i.getNivel())));
        return listaSalida;
    }

    public DeporteResponseDto buscarUnDeporte(String nombre) {
        Optional<Deporte> busqueda = deportes
                .stream()
                .filter(i -> i.getNombre().equals(nombre)).findFirst();
        DeporteResponseDto salida;
        if(busqueda.isEmpty()) salida = new DeporteResponseDto();
        else salida = new DeporteResponseDto(busqueda.get().getNombre(),busqueda.get().getNivel());
        return salida;
    }

    public List<DeportistaResponseDto> buscarDeportistas() {
        return StreamUtils.zip(personas.stream(),deportes.stream(),(p,d) -> new DeportistaResponseDto(
                p.getNombre() + " " +p.getApellido(),
                        d.getNombre()))
                .collect(Collectors.toList());
    }
}
