package com.example.persona.repositories;

import com.example.persona.model.Deporte;
import com.example.persona.model.Persona;
import com.example.persona.model.enums.NivelEnum;

import java.util.*;

public class DeporteRepository {
    private static List<Deporte> Deportes = new ArrayList<Deporte>(List.of(
            new Deporte(1, "Futbol", NivelEnum.Principiante),
            new Deporte(2, "Basket", NivelEnum.Principiante),
            new Deporte(3, "Volley", NivelEnum.Intermedio),
            new Deporte(4, "Natacion", NivelEnum.Avanzado)));

    public List<Deporte> getDeportes(){
        return Deportes;
    }
    public Optional<Deporte> getDeporteById(int id){
        return Deportes.stream().filter(dep->dep.getId()==id).findFirst();
    }

}
