package com.ORM.jpa.Service;

import com.ORM.jpa.Models.Person;

import java.util.List;

public interface IPersonService {
    Person createPerson(Person person);
    Person getById(Integer id);
    List<Person> getAll();

    void delete(Integer id);

}
