package com.bootcamp.Deportistas.repository;

import com.bootcamp.Deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository {

    List<Deporte> deportes;

    public DeporteRepository(){
        deportes = new ArrayList<>();
        deportes.add(new Deporte("Atletismo", "amateur"));
        deportes.add(new Deporte("Natacion", "Pro player"));

    }

    public List<Deporte> getDeportes(){
        return deportes;
    }
}
