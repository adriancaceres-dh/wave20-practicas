package com.ORM.jpa.Service;

import com.ORM.jpa.Models.Person;
import com.ORM.jpa.Repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    @Autowired
    IPersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        var createdPerson = personRepository.save(person);
        return createdPerson;
    }

    @Override
    public Person getById(Integer id) {
        return personRepository.findById(id).get();
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        personRepository.delete(getById(id));
    }


}
