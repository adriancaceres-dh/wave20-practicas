package com.DTOyResponseEntity.DTOyResponseEntity.service;

import com.DTOyResponseEntity.DTOyResponseEntity.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    private List<Persona> personas = new ArrayList<>();
    private DeporteService deporteService = new DeporteService();
    public PersonaService(){
        personas.add(new Persona("nombre_1","apellido_1",12,deporteService.buscarPorNombre("deporte_1")));
        personas.add(new Persona("nombre_2","apellido_2",13,deporteService.buscarPorNombre("deporte_2")));
        personas.add(new Persona("nombre_3","apellido_3",14,deporteService.buscarPorNombre("deporte_3")));
        personas.add(new Persona("nombre_4","apellido_4",15,deporteService.buscarPorNombre("deporte_4")));
    }
    public List<Persona> getTodasLasPersonas(){
        return personas;
    }
}
