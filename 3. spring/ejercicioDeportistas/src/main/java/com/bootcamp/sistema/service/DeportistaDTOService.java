package com.bootcamp.sistema.service;

import com.bootcamp.sistema.dto.DeportistaDTO;

import java.util.ArrayList;
import java.util.List;

public class DeportistaDTOService {
    private List<DeportistaDTO> deportistas;

    public DeportistaDTOService() {
        deportistas = new ArrayList<>();

        //En el caso de contar con datos de personas y deportes los campos se llenarian con los datos provenientes de los objetos persona y deporte, por el momento estan hardcodeados
        //deportistaDTO.setNombre(persona.getNombre()) , deportistaDTO.setApellido(persona.getApellido()), deportistaDTO.setDeporte(deporte.getNombre())
        deportistas.add(new DeportistaDTO("Maria", "Ramirez", "Hockey"));
        deportistas.add(new DeportistaDTO("Juan", "Gonzalez", "Volley"));
        deportistas.add(new DeportistaDTO("Rodrigo", "Perez", "Ajedrez"));
        deportistas.add(new DeportistaDTO("Valeria", "Jimenez", "Tennis"));

    }

    public List<DeportistaDTO> getDeportistas() {
        return deportistas;
    }

    public void setDeportistas(List<DeportistaDTO> deportistas) {
        this.deportistas = deportistas;
    }
}
