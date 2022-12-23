package com.bootcamp.ejercicio_deportistas.services.interfaces;

import com.bootcamp.ejercicio_deportistas.dtos.PersonaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService
{
    public List<PersonaDTO> buscarDeportistas();
}
