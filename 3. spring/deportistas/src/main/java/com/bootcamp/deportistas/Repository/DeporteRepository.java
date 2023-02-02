package com.bootcamp.deportistas.Repository;

import com.bootcamp.deportistas.Model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository {
    private List<Deporte> deportes;
    public DeporteRepository(){
        deportes = new ArrayList<>();
        deportes.add(new Deporte("Altletismo", "Avanzado"));
        deportes.add(new Deporte("Natacion", "Principiante"));
        deportes.add(new Deporte("Handball", "Intermedio"));
    }
    public List<Deporte> getDeportes() {
        return deportes;
    }

}
