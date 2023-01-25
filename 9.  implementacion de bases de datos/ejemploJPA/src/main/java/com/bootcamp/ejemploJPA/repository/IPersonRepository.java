package com.bootcamp.ejemploJPA.repository;

import com.bootcamp.ejemploJPA.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Integer> {
}
