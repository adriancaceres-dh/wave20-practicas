package com.JPA.demo.service;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;

import java.util.List;

public interface IPersonService {

    PersonDTO savePerson(PersonDTO personDTO);

    PersonDTO getPersonById(Integer id);

    List<PersonDTO> getAllPeople();

    MessageDTO deletePersona(Integer id);
}
