package com.example.demo.service;

import com.example.demo.dto.MessageDto;
import com.example.demo.dto.PersonDto;
import com.example.demo.dto.VehicleDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Person;
import com.example.demo.model.Vehicle;
import com.example.demo.repository.IPersonRepository;
import com.example.demo.repository.IVehicleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService{

    @Autowired
    IPersonRepository personRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public PersonDto saveEntity(PersonDto dto) {
        Person person = mapper.map(dto, Person.class);
        person.setEliminado(false);
        return mapper.map(personRepository.save(person), PersonDto.class);
    }

    @Override
    public PersonDto getEntityById(Integer id) throws NotFoundException {
        Optional<Person> person = personRepository.findById(id);
        if (!person.isPresent())
            throw new NotFoundException(new MessageDto(404, "No se encontró el recurso solicitado"));
        return mapper.map(person.get(), PersonDto .class);

    }

    @Override
    public List<PersonDto> getAllEntities() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(v -> mapper.map(v, PersonDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MessageDto deleteEntity(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent() && person.get().isEliminado())
            return new MessageDto(400, "El recurso no existe");
        personRepository.logicDelete(id);
        return new MessageDto(200, "El recurso fue eliminado con exito");
    }
}
