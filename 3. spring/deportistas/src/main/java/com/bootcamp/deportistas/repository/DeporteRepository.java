package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository implements IDeporteRepository {

    //Creamos una lista con deportes ingresados a continuación a mano
    private List<Deporte> deporteList;

    //Constructor
    public DeporteRepository() {
        //Inicializamos la lista con un ArrayList
        this.deporteList = new ArrayList<>();
        Deporte deporte1 = Deporte.builder()
                .nombre("Natación")
                .nivel(new ArrayList<>())
                .build();

        Deporte deporte2 = Deporte.builder()
                .nombre("Gimnasia Artistica")
                .nivel(new ArrayList<>())
                .build();

        Deporte deporte3 = Deporte.builder()
                .nombre("Ballet")
                .nivel(new ArrayList<>())
                .build();

        Deporte deporte4 = Deporte.builder()
                .nombre("Volley")
                .nivel(new ArrayList<>())
                .build();

        deporte1.getNivel().add("Principiante");
        deporte1.getNivel().add("Intermedio");
        deporte1.getNivel().add("Avanzado");

        deporte2.getNivel().add("Principiante");
        deporte2.getNivel().add("Intermedio");
        deporte2.getNivel().add("Avanzado");

        deporte3.getNivel().add("Principiante");
        deporte3.getNivel().add("Intermedio");
        deporte3.getNivel().add("Avanzado");

        deporte4.getNivel().add("Principiante");
        deporte4.getNivel().add("Intermedio");
        deporte4.getNivel().add("Avanzado");

        deporteList.add(deporte1);
        deporteList.add(deporte2);
        deporteList.add(deporte3);
        deporteList.add(deporte4);

    }

    public List<Deporte> getDeporte() {
        return this.deporteList;
    }

    public Deporte getDeporteByName(String nombreDeporte) {
        return this.deporteList.stream()
                .filter(deporte -> deporte.getNombre() == nombreDeporte)
                .findAny()
                .orElse(null);
    }
}
