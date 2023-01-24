package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{
  private final IPersonRepository iPersonRepository;

  public PersonService(IPersonRepository iPersonRepository) {
    this.iPersonRepository = iPersonRepository;
  }

  @Override
  public Person createPerson(Person person) {
    assert iPersonRepository.findById(person.getId()).isEmpty();
    return iPersonRepository.save(person);
  }

  @Override
  public Person getById(int id) {
    return iPersonRepository.findById(id).orElseThrow(
            () -> {throw  new RuntimeException("ID no encontrado");}
    );
  }

  @Override
  public List<Person> getAllPeople() {
    return iPersonRepository.findAll();
  }
}
