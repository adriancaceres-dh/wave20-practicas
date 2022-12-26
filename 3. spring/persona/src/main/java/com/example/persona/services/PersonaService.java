package com.example.persona.services;

import com.example.persona.model.dtos.PersonaConDeporteDto;
import com.example.persona.repositories.DeporteRepository;
import com.example.persona.repositories.PersonaRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonaService {

    private static PersonaRepository _repo = new PersonaRepository();
    private static DeporteService _depoService = new DeporteService();

    public List<PersonaConDeporteDto> ObtenerPersonasConSusDeportes(){

        List<PersonaConDeporteDto> resultado = _repo.getPersonas().stream().filter(persona -> 0!=persona.getDeportes()).map(persona ->
            new PersonaConDeporteDto(persona.getNombre(), persona.getApellido(),  _depoService.ObtenerDeporteById(persona.getDeportes()).get().getNombre())
        ).toList();


        return resultado;
    }
}
