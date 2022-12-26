package com.bootcamp.appstarwars.service;

import com.bootcamp.appstarwars.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDto> find(String query);
}
