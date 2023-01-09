package com.bootcamp.deportistas.repository;

import com.bootcamp.deportistas.model.Deporte;

import java.util.List;

public interface IDeporteRepository {
    List<Deporte> getDeporte();
    Deporte getDeporteByName(String nombreDeporte);
}
