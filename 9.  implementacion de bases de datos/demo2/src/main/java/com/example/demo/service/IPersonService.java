package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;

public interface IPersonService {

  Person createPerson(Person person);
  Person getById(int id);
  List<Person> getAllPeople();
}
