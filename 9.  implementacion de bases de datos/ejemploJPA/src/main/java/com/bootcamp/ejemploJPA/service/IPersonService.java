package com.bootcamp.ejemploJPA.service;

import com.bootcamp.ejemploJPA.entity.Person;

import java.util.List;

public interface IPersonService {

    Person createPerson(Person person);

    Person getById(Integer id);

    List<Person> getAllPeople();

    Integer deletePerson(Integer id);
}
