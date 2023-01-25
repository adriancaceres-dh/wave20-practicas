package com.JPA.demo.service;

import com.JPA.demo.dto.MessageDTO;
import com.JPA.demo.dto.PersonDTO;
import com.JPA.demo.entity.Person;
import com.JPA.demo.repository.IPersonRepository;
import com.JPA.demo.service.interfaces.IPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {

    @Autowired
    IPersonRepository personaRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public PersonDTO saveEntity(PersonDTO personDTO) {
        var personEntity = mapper.map(personDTO, Person.class);

        personEntity = personaRepository.save(personEntity);

        return mapper.map(personEntity, PersonDTO.class);
    }



    @Override
    public PersonDTO getEntityById(Integer id) {

        var person = personaRepository.findById(id);

        return mapper.map(person, PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAllEntities() {

        var list = personaRepository.findAll();

        return list.stream().map(
                person -> mapper.map(person, PersonDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDTO deleteEntity(Integer id) {
        if(personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
                return MessageDTO.builder()
                    .message("Se elimino la persona con id:" + id)
                    .action("DELETE")
                    .build();
        }
        else throw new RuntimeException();
    }
}
