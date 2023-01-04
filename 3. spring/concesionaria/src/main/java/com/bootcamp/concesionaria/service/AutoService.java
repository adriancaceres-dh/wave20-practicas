package com.bootcamp.concesionaria.service;

import com.bootcamp.concesionaria.dto.AutosDTO;

import java.time.LocalDate;
import java.util.List;

public class AutoService implements AutoServiceInterface {

    @Override
    public List<AutosDTO> todosLosUsados() {
        return null;
    }

    @Override
    public List<AutosDTO> fabricadosDesde(LocalDate fechaFabricacion) {
        return null;
    }

    @Override
    public List<AutosDTO> segunPrecio(String precio) {
        return null;
    }
}
