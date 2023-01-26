package com.jpa.implementacion.service;

import com.jpa.implementacion.dto.PersonDto;

import java.util.List;

public interface IPersonService {

    PersonDto savePerson(PersonDto personDto);

    List<PersonDto> getAll();

    Long countPerson();
}
