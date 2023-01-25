package com.bootcamp.ejemploJPA.service;

import com.bootcamp.ejemploJPA.entity.Person;
import com.bootcamp.ejemploJPA.repository.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{

    private final IPersonRepository personRepository;

    public PersonService(IPersonRepository iPersonRepository) {
        this.personRepository = iPersonRepository;
    }

    @Override
    public Person createPerson(Person person) {

        var personReturn = personRepository.save(person);

        return personReturn;
    }

    @Override
    public Person getById(Integer id) {
        return personRepository.findById(id).orElseThrow(
                () -> { throw new RuntimeException("No se puede encontrar este Id");}
        );
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Integer deletePerson(Integer id) {

        personRepository.deleteById(id);

        return id;
    }
}
