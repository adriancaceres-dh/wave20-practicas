package com.DTOyResponseEntity.DTOyResponseEntity.service;

import com.DTOyResponseEntity.DTOyResponseEntity.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DeporteService {
    List<Deporte> deportes = new ArrayList<>();
    public DeporteService(){
        deportes.add(new Deporte("deporte_1","nivel_1"));
        deportes.add(new Deporte("deporte_2","nivel_2"));
        deportes.add(new Deporte("deporte_3","nivel_3"));
        deportes.add(new Deporte("deporte_4","nivel_4"));
    }
    public List<Deporte> getTodosLosDeportes(){
        return deportes;
    }
    public Deporte buscarPorNombre(String name){
        return deportes.stream()
                .filter(d -> d.getNombre().equals(name))
                .findAny()
                .orElse(null);
    }
}
