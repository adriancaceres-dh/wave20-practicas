package com.JPA.demo.service;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.entity.Person;
import com.JPA.demo.repository.IPersonRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService{

    @Autowired
    IPersonRepository repository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public PersonDTO savePerson(PersonDTO personDTO) {
        var personEntity = mapper.map(personDTO, Person.class);

        personEntity = repository.save(personEntity);

        return mapper.map(personEntity, PersonDTO.class);
    }



    @Override
    public PersonDTO getPersonById(Integer id) {

        var person = repository.findById(id);

        return mapper.map(person, PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAllPeople() {

        var list = repository.findAll();

        return list.stream().map(
                person -> mapper.map(person, PersonDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDTO deletePersona(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
                return MessageDTO.builder()
                    .message("Se elimino la persona con id:" + id)
                    .action("DELETE")
                    .build();
        }
        else throw new RuntimeException();
    }

}
