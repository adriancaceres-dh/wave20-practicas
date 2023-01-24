package com.JPA.demo.service;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.entity.Person;
import com.JPA.demo.exceptions.PersonNotFoundException;
import com.JPA.demo.repository.IPersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{

    final
    IPersonRepository repository;

    ModelMapper mapper = new ModelMapper();

    public PersonService(IPersonRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonDTO savePerson(PersonDTO personDTO) {
        var personEntity = mapper.map(personDTO, Person.class);

        personEntity = repository.save(personEntity);

        return mapper.map(personEntity, PersonDTO.class);
    }

    @Override
    public PersonDTO getPersonById(Integer id) {

        if(!repository.existsById(id)) {
            throw new PersonNotFoundException("No se encontro la persona con id: " + id);
        }

        return mapper.map(repository.findById(id), PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAllPeople() {

        var list = repository.findAll();

        return list.stream().map(
                person -> mapper.map(person, PersonDTO.class)
        ).toList();
    }

    @Override
    public MessageDTO deletePersona(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
                return MessageDTO.builder()
                    .message("Se elimino la persona con id: " + id)
                    .action("DELETE")
                    .build();
        }
        else {
            throw new PersonNotFoundException("No se encontro la persona con id: " + id);
        }
    }

}
