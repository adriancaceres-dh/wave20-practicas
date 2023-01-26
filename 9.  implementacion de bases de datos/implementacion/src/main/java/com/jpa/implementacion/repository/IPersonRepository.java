package com.jpa.implementacion.repository;

import com.jpa.implementacion.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<Person, Long> {

}
