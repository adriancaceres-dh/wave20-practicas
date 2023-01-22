package com.deportistas.deportistas.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deportistas.deportistas.dto.response.ListaPersonasYDeportesDto;
import com.deportistas.deportistas.models.Persona;
import com.deportistas.deportistas.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private ModelMapper mapper;
    
    public List<ListaPersonasYDeportesDto > listaDePersonas() {
 List<Persona>  personas =      personaRepository.listarPersonas();
 List<ListaPersonasYDeportesDto> personasDto = new ArrayList<>();
 personas.stream().forEach(p->  personasDto.add(mapper.map(p, ListaPersonasYDeportesDto.class)));
  return personasDto;
    }
}
