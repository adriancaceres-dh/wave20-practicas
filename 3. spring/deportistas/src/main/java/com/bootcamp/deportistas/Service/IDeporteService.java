package com.bootcamp.deportistas.Service;

import com.bootcamp.deportistas.DTOs.DeporteDTO;

import java.util.List;

public interface IDeporteService {
    public List<DeporteDTO> findAllSports();
    public DeporteDTO findSport(String name);
}
