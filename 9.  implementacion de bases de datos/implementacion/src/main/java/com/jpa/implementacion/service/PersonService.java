package com.jpa.implementacion.service;

import com.jpa.implementacion.dto.PersonDto;
import com.jpa.implementacion.entity.Person;
import com.jpa.implementacion.repository.IPersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {

    private final IPersonRepository personRepository;

    ModelMapper modelMapper = new ModelMapper();

    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public PersonDto savePerson(PersonDto personDto) {
        Person entity = modelMapper.map(personDto, Person.class);
        personRepository.save(entity);
        return modelMapper.map(entity, PersonDto.class);
    }

    @Override
    public List<PersonDto> getAll() {
        List<Person> list = personRepository.findAll();
        return list.stream().map(person -> modelMapper.map(person, PersonDto.class)).collect(Collectors.toList());
    }

    @Override
    public Long countPerson() {
        return personRepository.count();
    }
}
