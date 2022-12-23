package com.bootcamp.ejercicio_deportistas.services;

import com.bootcamp.ejercicio_deportistas.dtos.DeporteDTO;
import com.bootcamp.ejercicio_deportistas.models.Deporte;
import com.bootcamp.ejercicio_deportistas.services.interfaces.IDeporteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DeporteService implements IDeporteService {
    private List<Deporte> deportes;
    public DeporteService() {
        deportes = new ArrayList<>();
        deportes.add(new Deporte("Futbol",1));
    }

    @Override
    public List<DeporteDTO> listarDesportes() {
        return deportes.stream()
                .map(x-> new DeporteDTO(x.getNombre(),x.getNivel()))
                .collect(Collectors.toList());
    }

    @Override
    public int consultarDeporte(String nombre) {
        Optional<Deporte> deporte =  deportes.stream().filter(x->x.getNombre().toLowerCase(Locale.ROOT)
                .equals(nombre.toLowerCase(Locale.ROOT))).findFirst();
        if(deporte.isPresent()){
            return deporte.get().getNivel();
        }else {
            return -1;
        }
    }
}
