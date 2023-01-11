package com.bootcamp.ejercicio.covid.services.interfaces;

import com.bootcamp.ejercicio.covid.dto.PersonaDTO;
import com.bootcamp.ejercicio.covid.models.Persona;
import com.bootcamp.ejercicio.covid.models.Sintoma;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ISintomaService {
    public List<Sintoma> buscarSintomas();

    public Optional<Sintoma> buscarSintoma(String nombre);

    public List<PersonaDTO> buscarPersonasDeRiesgo();
}
