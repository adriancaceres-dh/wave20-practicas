package com.bootcamp.deportistas.service;

import com.bootcamp.deportistas.dto.PersonaDeporteDTO;
import com.bootcamp.deportistas.model.Deporte;

import java.util.List;

public interface IDeporteService {

    List<PersonaDeporteDTO> getPersonaDeporte();
    List<Deporte> getDeporte();
    Deporte getDeporteByName(String nombreDeporte);

}
