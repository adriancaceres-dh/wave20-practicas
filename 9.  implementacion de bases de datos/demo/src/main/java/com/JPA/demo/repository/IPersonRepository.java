package com.JPA.demo.repository;

import com.JPA.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPersonRepository extends JpaRepository<Person, Integer> {
}
