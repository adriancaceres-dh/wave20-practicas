package com.bootcamp.calorias.service;

import com.bootcamp.calorias.dto.PlatoDto;
import com.bootcamp.calorias.model.Plato;
import com.bootcamp.calorias.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoService {
    @Autowired
    private PlatoRepository platoRepository;

    public PlatoDto getPlato(String name, double weight) {
        Plato plato = platoRepository.findByName(name);
        return new PlatoDto(plato, weight);
    }
}
