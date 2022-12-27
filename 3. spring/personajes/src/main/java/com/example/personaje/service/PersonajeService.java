package com.example.personaje.service;

import com.example.personaje.dto.PersonajeDto;
import com.example.personaje.model.Personaje;
import com.example.personaje.repository.PersonaRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService{
    @Autowired
    private PersonaRepository personaRepository;
    private final ModelMapper mapper= new ModelMapper();
   public List<PersonajeDto> findByName(String name){
       List<Personaje> personajeList = personaRepository.getPersonajeList();
       //System.out.println(personajeList.stream().filter(x->x.getName().contains(name)));
       return personajeList.stream().filter(x->x.getName().contains(name)).collect(Collectors.toList())
               .stream().map(p-> mapper.map(p,PersonajeDto.class)).collect(Collectors.toList());

      /*  personaRepository.getPersonajeList().stream()
               .filter(x->x.getName().contains(name))
               .map(p -> mapper.map(p,PersonajeDto.class))
               .collect(Collectors.toList());*/

   }

}
