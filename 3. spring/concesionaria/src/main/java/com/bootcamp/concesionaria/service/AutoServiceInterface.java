package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.AutosDTO;

import java.time.LocalDate;
import java.util.List;

public interface AutoServiceInterface {

    public List<AutosDTO> todosLosUsados ();
    public List<AutosDTO> fabricadosDesde(LocalDate fechaFabricacion);
    public List<AutosDTO> segunPrecio(String precio);

}
